import java.util.*;

/* ============================================================
   Project Covering 18 Design Patterns
   ------------------------------------------------------------
   CREATIONAL:
   1) Factory Method
   2) Abstract Factory
   3) Builder
   4) Prototype
   5) Singleton

   STRUCTURAL:
   6) Adapter
   7) Facade
   8) Composite
   9) Decorator
   10) Proxy
   11) Bridge

   BEHAVIORAL:
   12) Chain of Responsibility
   13) Command
   14) Mediator
   15) Memento
   16) Iterator
   17) Strategy
   18) State
   19) Template Method
   20) Observer
   21) Visitor
   ============================================================ */

/* --------------------------- 5) SINGLETON ---------------------------
   Global configuration (e.g., DB URL, feature flags).
   Only one instance exists across the app.
------------------------------------------------------------------------ */
class Config {
    private static final Config INSTANCE = new Config();
    public final Map<String, String> props = new HashMap<>();

    private Config() {
        props.put("storage", "inmem");
        props.put("env", "demo");
    }

    public static Config get() {
        return INSTANCE;
    }
}

/* --------------------------- 4) PROTOTYPE ---------------------------
   Document templates cloned to create new documents.
------------------------------------------------------------------------ */
interface Prototype<T> {
    T copy();
}

class DocTemplate implements Prototype<DocTemplate> {
    String title;
    List<String> sections = new ArrayList<>();

    DocTemplate(String title, List<String> sections) {
        this.title = title;
        this.sections.addAll(sections);
    }

    public DocTemplate copy() {
        return new DocTemplate(title, new ArrayList<>(sections));
    }
}

/* --------------------------- 1) FACTORY METHOD ----------------------
   Factory Method to create different Report types from a common creator.
------------------------------------------------------------------------ */
interface Report {
    String render();
}

class PdfReport implements Report {
    public String render() {
        return "PDF Report";
    }
}

class HtmlReport implements Report {
    public String render() {
        return "HTML Report";
    }
}

abstract class ReportCreator {
    // Factory Method — subclasses decide which product to create
    protected abstract Report create();

    public String generate() {
        Report r = create();
        return "Generated: " + r.render();
    }
}

class PdfReportCreator extends ReportCreator {
    protected Report create() {
        return new PdfReport();
    }
}

class HtmlReportCreator extends ReportCreator {
    protected Report create() {
        return new HtmlReport();
    }
}

/* --------------------------- 3) BUILDER -----------------------------
   Build a complex ReportContent step by step (title, body, charts).
------------------------------------------------------------------------ */
class ReportContent {
    final String title;
    final List<String> body;
    final boolean includeChart;

    private ReportContent(Builder b) {
        title = b.title;
        body = b.body;
        includeChart = b.includeChart;
    }

    static class Builder {
        String title;
        List<String> body = new ArrayList<>();
        boolean includeChart;

        Builder title(String t) {
            this.title = t;
            return this;
        }

        Builder addParagraph(String p) {
            body.add(p);
            return this;
        }

        Builder chart(boolean c) {
            includeChart = c;
            return this;
        }

        ReportContent build() {
            return new ReportContent(this);
        }
    }
}

/* --------------------------- 2) ABSTRACT FACTORY --------------------
   Families of UI widgets (Admin Console) for Web vs Desktop.
------------------------------------------------------------------------ */
interface Button {
    String draw();
}

interface Checkbox {
    String draw();
}

class WebButton implements Button {
    public String draw() {
        return "<button>Web</button>";
    }
}

class WebCheckbox implements Checkbox {
    public String draw() {
        return "<input type='checkbox'/>";
    }
}

class DesktopButton implements Button {
    public String draw() {
        return "[DesktopButton]";
    }
}

class DesktopCheckbox implements Checkbox {
    public String draw() {
        return "[DesktopCheckbox]";
    }
}

interface UIFactory {
    Button button();

    Checkbox checkbox();
}

class WebFactory implements UIFactory {
    public Button button() {
        return new WebButton();
    }

    public Checkbox checkbox() {
        return new WebCheckbox();
    }
}

class DesktopFactory implements UIFactory {
    public Button button() {
        return new DesktopButton();
    }

    public Checkbox checkbox() {
        return new DesktopCheckbox();
    }
}

/* --------------------------- 6) ADAPTER -----------------------------
   Adapt legacy XML report service to new JSON service interface.
------------------------------------------------------------------------ */
interface JsonReportService {
    String getReportJson();
}

class LegacyXmlReportService {
    String getXml() {
        return "<report>legacy</report>";
    }
}

class XmlToJsonAdapter implements JsonReportService {
    private final LegacyXmlReportService legacy;

    XmlToJsonAdapter(LegacyXmlReportService legacy) {
        this.legacy = legacy;
    }

    public String getReportJson() {
        // pretend conversion
        String xml = legacy.getXml();
        return "{\"report\":\"converted-from-xml\"}";
    }
}

/* --------------------------- 9) DECORATOR ---------------------------
   DataStream with optional compression/encryption decorators.
------------------------------------------------------------------------ */
interface DataStream {
    void write(String data);
}

class MemoryStream implements DataStream {
    public final List<String> storage = new ArrayList<>();

    public void write(String data) {
        storage.add(data);
        System.out.println("Write raw: " + data);
    }
}

abstract class StreamDecorator implements DataStream {
    protected final DataStream wrap;

    StreamDecorator(DataStream s) {
        this.wrap = s;
    }
}

class CompressDecorator extends StreamDecorator {
    CompressDecorator(DataStream s) {
        super(s);
    }

    public void write(String data) {
        wrap.write("ZIP(" + data + ")");
    }
}

class EncryptDecorator extends StreamDecorator {
    EncryptDecorator(DataStream s) {
        super(s);
    }

    public void write(String data) {
        wrap.write("ENC(" + data + ")");
    }
}

/* --------------------------- 10) PROXY ------------------------------
   Access control proxy around a document repository.
------------------------------------------------------------------------ */
interface DocRepo {
    void save(String docId, String content);

    String load(String docId);
}

class InMemoryDocRepo implements DocRepo {
    private final Map<String, String> db = new HashMap<>();

    public void save(String id, String c) {
        db.put(id, c);
    }

    public String load(String id) {
        return db.get(id);
    }
}

class SecuredRepoProxy implements DocRepo {
    private final DocRepo real;
    private final Set<String> allowed;

    SecuredRepoProxy(DocRepo real, Set<String> allowed) {
        this.real = real;
        this.allowed = allowed;
    }

    private void check(String action) {
        if (!allowed.contains(action)) throw new RuntimeException("Access denied: " + action);
    }

    public void save(String docId, String c) {
        check("save");
        real.save(docId, c);
    }

    public String load(String docId) {
        check("load");
        return real.load(docId);
    }
}

/* --------------------------- 8) COMPOSITE ---------------------------
   Folder/File tree; treat leaf and composite uniformly.
------------------------------------------------------------------------ */
interface Node {
    String name();

    int size(); // sum for folder, bytes for file

    default void add(Node n) {
        throw new UnsupportedOperationException();
    }
}

class FileLeaf implements Node {
    private final String name;
    private final int bytes;

    FileLeaf(String n, int b) {
        name = n;
        bytes = b;
    }

    public String name() {
        return name;
    }

    public int size() {
        return bytes;
    }
}

class FolderComposite implements Node {
    private final String name;
    private final List<Node> children = new ArrayList<>();

    FolderComposite(String n) {
        name = n;
    }

    public String name() {
        return name;
    }

    public int size() {
        return children.stream().mapToInt(Node::size).sum();
    }

    public void add(Node n) {
        children.add(n);
    }

    public List<Node> children() {
        return children;
    }
}

/* --------------------------- 11) BRIDGE -----------------------------
   Separate Report abstraction from OutputChannel implementation.
------------------------------------------------------------------------ */
interface OutputChannel {
    void send(String payload);
}

class EmailChannel implements OutputChannel {
    public void send(String p) {
        System.out.println("Email => " + p);
    }
}

class SlackChannel implements OutputChannel {
    public void send(String p) {
        System.out.println("Slack => " + p);
    }
}

abstract class ReportMessage {
    protected final OutputChannel channel;

    protected ReportMessage(OutputChannel c) {
        channel = c;
    }

    abstract void publish(String content);
}

class AuditReportMessage extends ReportMessage {
    AuditReportMessage(OutputChannel c) {
        super(c);
    }

    void publish(String content) {
        channel.send("AUDIT: " + content);
    }
}

/* --------------------------- 12) CHAIN OF RESPONSIBILITY -----------
   Support ticket pipeline: validation → priority → assignment.
------------------------------------------------------------------------ */
abstract class TicketHandler {
    private TicketHandler next;

    public TicketHandler linkWith(TicketHandler n) {
        this.next = n;
        return n;
    }

    public void handle(Map<String, Object> ticket) {
        if (process(ticket) && next != null) next.handle(ticket);
    }

    protected abstract boolean process(Map<String, Object> t);
}

class ValidateHandler extends TicketHandler {
    protected boolean process(Map<String, Object> t) {
        boolean ok = t.containsKey("title");
        System.out.println("Validate: " + ok);
        return ok;
    }
}

class PriorityHandler extends TicketHandler {
    protected boolean process(Map<String, Object> t) {
        t.putIfAbsent("priority", "NORMAL");
        System.out.println("Priority: " + t.get("priority"));
        return true;
    }
}

class AssignHandler extends TicketHandler {
    protected boolean process(Map<String, Object> t) {
        t.put("assignee", "agent-1");
        System.out.println("Assigned to agent-1");
        return true;
    }
}

/* --------------------------- 13) COMMAND ---------------------------
   Encapsulate actions; can log/undo/queue.
------------------------------------------------------------------------ */
interface Command {
    void execute();
}

class CreateUserCommand implements Command {
    private final List<String> store;
    private final String user;

    CreateUserCommand(List<String> s, String u) {
        store = s;
        user = u;
    }

    public void execute() {
        store.add(user);
        System.out.println("User created: " + user);
    }
}

class DeleteUserCommand implements Command {
    private final List<String> store;
    private final String user;

    DeleteUserCommand(List<String> s, String u) {
        store = s;
        user = u;
    }

    public void execute() {
        store.remove(user);
        System.out.println("User deleted: " + user);
    }
}

class Invoker {
    private final Queue<Command> q = new ArrayDeque<>();

    void add(Command c) {
        q.add(c);
    }

    void run() {
        while (!q.isEmpty()) q.poll().execute();
    }
}

/* --------------------------- 14) MEDIATOR --------------------------
   Simple chatroom; users talk through mediator.
------------------------------------------------------------------------ */
interface Mediator {
    void send(String msg, Colleague from);

    void join(Colleague c);
}

class ChatRoom implements Mediator {
    private final List<Colleague> members = new ArrayList<>();

    public void send(String msg, Colleague from) {
        for (var c : members) if (c != from) c.recv(from.name + ": " + msg);
    }

    public void join(Colleague c) {
        members.add(c);
    }
}

abstract class Colleague {
    protected final Mediator m;
    protected final String name;

    Colleague(Mediator m, String name) {
        this.m = m;
        this.name = name;
        m.join(this);
    }

    void say(String msg) {
        m.send(msg, this);
    }

    void recv(String msg) {
        System.out.println(name + " sees: " + msg);
    }
}

/* --------------------------- 15) MEMENTO ---------------------------
   Editor text undo.
------------------------------------------------------------------------ */
class TextMemento {
    final String state;

    TextMemento(String s) {
        state = s;
    }
}

class Editor {
    private String text = "";

    void type(String s) {
        text += s;
        System.out.println("Text: " + text);
    }

    TextMemento save() {
        return new TextMemento(text);
    }

    void restore(TextMemento m) {
        text = m.state;
        System.out.println("Undo -> " + text);
    }
}

/* --------------------------- 16) ITERATOR --------------------------
   Custom collection iterator for documents.
------------------------------------------------------------------------ */
class DocCollection implements Iterable<String> {
    private final List<String> docs = new ArrayList<>();

    void add(String d) {
        docs.add(d);
    }

    public Iterator<String> iterator() {
        return docs.iterator();
    }
}

/* --------------------------- 17) STRATEGY --------------------------
   Sort documents differently.
------------------------------------------------------------------------ */
interface SortStrategy {
    void sort(List<String> list);
}

class AlphaSort implements SortStrategy {
    public void sort(List<String> l) {
        Collections.sort(l);
    }
}

class LengthSort implements SortStrategy {
    public void sort(List<String> l) {
        l.sort(Comparator.comparingInt(String::length));
    }
}

class DocSorter {
    private SortStrategy strategy;

    DocSorter(SortStrategy s) {
        strategy = s;
    }

    void set(SortStrategy s) {
        strategy = s;
    }

    void sort(List<String> l) {
        strategy.sort(l);
    }
}

/* --------------------------- 18) STATE ------------------------------
   Document lifecycle: Draft -> Review -> Published -> Archived
------------------------------------------------------------------------ */
interface DocState {
    void submit(DocumentCtx ctx);

    void publish(DocumentCtx ctx);

    void archive(DocumentCtx ctx);

    String name();
}

class DocumentCtx {
    private DocState state = new Draft();

    void set(DocState s) {
        state = s;
    }

    void submit() {
        state.submit(this);
    }

    void publish() {
        state.publish(this);
    }

    void archive() {
        state.archive(this);
    }

    String state() {
        return state.name();
    }
}

class Draft implements DocState {
    public void submit(DocumentCtx c) {
        c.set(new Review());
        System.out.println("→ to REVIEW");
    }

    public void publish(DocumentCtx c) {
        System.out.println("Cannot publish in DRAFT");
    }

    public void archive(DocumentCtx c) {
        System.out.println("Cannot archive in DRAFT");
    }

    public String name() {
        return "DRAFT";
    }
}

class Review implements DocState {
    public void submit(DocumentCtx c) {
        System.out.println("Already in REVIEW");
    }

    public void publish(DocumentCtx c) {
        c.set(new Published());
        System.out.println("✓ PUBLISHED");
    }

    public void archive(DocumentCtx c) {
        c.set(new Archived());
        System.out.println("🗄 ARCHIVED from REVIEW");
    }

    public String name() {
        return "REVIEW";
    }
}

class Published implements DocState {
    public void submit(DocumentCtx c) {
        System.out.println("Already PUBLISHED");
    }

    public void publish(DocumentCtx c) {
        System.out.println("Already PUBLISHED");
    }

    public void archive(DocumentCtx c) {
        c.set(new Archived());
        System.out.println("🗄 ARCHIVED");
    }

    public String name() {
        return "PUBLISHED";
    }
}

class Archived implements DocState {
    public void submit(DocumentCtx c) {
        System.out.println("Archived");
    }

    public void publish(DocumentCtx c) {
        System.out.println("Archived");
    }

    public void archive(DocumentCtx c) {
        System.out.println("Already archived");
    }

    public String name() {
        return "ARCHIVED";
    }
}

/* --------------------------- 19) TEMPLATE METHOD -------------------
   Skeleton for report generation with overridable steps.
------------------------------------------------------------------------ */
abstract class ReportTemplate {
    // Template method (final): algorithm skeleton
    public final void generate(ReportContent content) {
        preValidate(content);
        String data = fetchData(content);
        String rendered = render(data);
        postPublish(rendered);
    }

    protected void preValidate(ReportContent c) {
        System.out.println("Validate report: " + (c.title != null));
    }

    protected abstract String fetchData(ReportContent c);

    protected abstract String render(String data);

    protected void postPublish(String r) {
        System.out.println("Published: " + r);
    }
}

class AuditReportTemplate extends ReportTemplate {
    protected String fetchData(ReportContent c) {
        return "AUDIT_DATA(" + c.title + ")";
    }

    protected String render(String data) {
        return "AuditPDF[" + data + "]";
    }
}

/* --------------------------- 20) OBSERVER --------------------------
   User registration notifies listeners (email, audit).
------------------------------------------------------------------------ */
interface Observer {
    void update(String event, Object payload);
}

class EventBus {
    private final Map<String, List<Observer>> map = new HashMap<>();

    void on(String event, Observer o) {
        map.computeIfAbsent(event, k -> new ArrayList<>()).add(o);
    }

    void emit(String event, Object payload) {
        map.getOrDefault(event, List.of()).forEach(o -> o.update(event, payload));
    }
}

class UserService {
    private final List<String> users = new ArrayList<>();
    private final EventBus bus;

    UserService(EventBus b) {
        bus = b;
    }

    void register(String user) {
        users.add(user);
        bus.emit("user:registered", user);
    }
}

/* --------------------------- 21) VISITOR ---------------------------
   Run new operations over a fixed object structure (Composite tree).
------------------------------------------------------------------------ */
interface FsVisitor {
    void visit(FileLeaf f);

    void visit(FolderComposite d);
}

class SizeVisitor implements FsVisitor {
    int total = 0;

    public void visit(FileLeaf f) {
        total += f.size();
    }

    public void visit(FolderComposite d) {
        for (Node n : d.children()) {
            if (n instanceof FileLeaf) visit((FileLeaf) n);
            else if (n instanceof FolderComposite) visit((FolderComposite) n);
        }
    }
}

class PrintVisitor implements FsVisitor {
    private final String indent;

    PrintVisitor() {
        this.indent = "";
    }

    private PrintVisitor(String indent) {
        this.indent = indent;
    }

    public void visit(FileLeaf f) {
        System.out.println(indent + "- " + f.name());
    }

    public void visit(FolderComposite d) {
        System.out.println(indent + "+ " + d.name());
        for (Node n : d.children()) {
            if (n instanceof FileLeaf) new PrintVisitor(indent + "  ").visit((FileLeaf) n);
            else new PrintVisitor(indent + "  ").visit((FolderComposite) n);
        }
    }
}

/* --------------------------- 7) FACADE -----------------------------
   Simple API to orchestrate several subsystems for “generate & store report”.
------------------------------------------------------------------------ */
class ReportFacade {
    private final ReportCreator creator;  // Factory Method behind the scenes
    private final ReportTemplate template;// Template Method
    private final DocRepo repo;           // Could be behind a Proxy

    ReportFacade(ReportCreator c, ReportTemplate t, DocRepo r) {
        creator = c;
        template = t;
        repo = r;
    }

    public void generateAndStore(ReportContent content, String docId) {
        // 1) Template Method does validation/fetch/render
        template.generate(content);
        // 2) Factory Method produces a concrete Report artifact
        String artifact = creator.generate();
        // 3) Store via repository (maybe proxied for security)
        repo.save(docId, artifact);
        System.out.println("Facade stored doc: " + docId);
    }
}

/* =============================== DEMO =============================== */
public class Main {
    public static void main(String[] args) {
        System.out.println("== Singleton ==");
        System.out.println("Config env: " + Config.get().props.get("env"));

        System.out.println("\n== Prototype ==");
        DocTemplate base = new DocTemplate("Monthly Statement", List.of("Header", "Body", "Footer"));
        DocTemplate forVIP = base.copy();
        forVIP.sections.add("VIP Bonus");
        System.out.println("Template sections: " + forVIP.sections);

        System.out.println("\n== Factory Method ==");
        System.out.println(new PdfReportCreator().generate());
        System.out.println(new HtmlReportCreator().generate());

        System.out.println("\n== Builder ==");
        ReportContent rc = new ReportContent.Builder()
                .title("Q4 Audit").addParagraph("P1").addParagraph("P2").chart(true).build();
        System.out.println("Built report: " + rc.title + " / parts=" + rc.body.size());

        System.out.println("\n== Abstract Factory ==");
        UIFactory ui = (Math.random() > 0.5) ? new WebFactory() : new DesktopFactory();
        System.out.println(ui.button().draw() + " " + ui.checkbox().draw());

        System.out.println("\n== Adapter ==");
        JsonReportService svc = new XmlToJsonAdapter(new LegacyXmlReportService());
        System.out.println("JSON: " + svc.getReportJson());

        System.out.println("\n== Decorator ==");
        DataStream stream = new EncryptDecorator(new CompressDecorator(new MemoryStream()));
        stream.write("report-bytes");

        System.out.println("\n== Proxy ==");
        DocRepo repo = new SecuredRepoProxy(new InMemoryDocRepo(), Set.of("save", "load"));
        repo.save("doc-1", "CONTENT");
        System.out.println("Loaded: " + repo.load("doc-1"));

        System.out.println("\n== Composite + Visitor ==");
        FolderComposite root = new FolderComposite("root");
        FolderComposite docs = new FolderComposite("docs");
        root.add(docs);
        docs.add(new FileLeaf("a.txt", 1200));
        root.add(new FileLeaf("logo.png", 8000));
        PrintVisitor pv = new PrintVisitor();
        pv.visit(root);
        SizeVisitor sv = new SizeVisitor();
        sv.visit(root);
        System.out.println("Total size = " + sv.total);

        System.out.println("\n== Bridge ==");
        ReportMessage msg = new AuditReportMessage(new EmailChannel());
        msg.publish("Quarter closed");

        System.out.println("\n== Chain of Responsibility ==");
        Map<String, Object> ticket = new HashMap<>();
        ticket.put("title", "Login issue");
        new ValidateHandler().linkWith(new PriorityHandler()).linkWith(new AssignHandler()).handle(ticket);

        System.out.println("\n== Command ==");
        List<String> users = new ArrayList<>();
        Invoker inv = new Invoker();
        inv.add(new CreateUserCommand(users, "alice"));
        inv.add(new CreateUserCommand(users, "bob"));
        inv.add(new DeleteUserCommand(users, "alice"));
        inv.run();
        System.out.println("Users = " + users);

        System.out.println("\n== Mediator ==");
        ChatRoom room = new ChatRoom();
        Colleague u1 = new Colleague(room, "Alice") {
        };
        Colleague u2 = new Colleague(room, "Bob") {
        };
        u1.say("Hello!");
        u2.say("Hi!");

        System.out.println("\n== Memento ==");
        Editor ed = new Editor();
        var h = new Stack<TextMemento>();
        ed.type("Hello");
        h.push(ed.save());
        ed.type(", world");
        h.push(ed.save());
        ed.restore(h.pop());
        ed.restore(h.pop());

        System.out.println("\n== Iterator ==");
        DocCollection col = new DocCollection();
        col.add("R1");
        col.add("R2");
        for (String d : col) System.out.println("Iter item: " + d);

        System.out.println("\n== Strategy ==");
        List<String> docsList = new ArrayList<>(List.of("bbb", "a", "cc"));
        DocSorter sorter = new DocSorter(new AlphaSort());
        sorter.sort(docsList);
        System.out.println(docsList);
        sorter.set(new LengthSort());
        sorter.sort(docsList);
        System.out.println(docsList);

        System.out.println("\n== State ==");
        DocumentCtx dctx = new DocumentCtx();
        System.out.println("State: " + dctx.state());
        dctx.submit();
        dctx.publish();
        System.out.println("State: " + dctx.state());
        dctx.archive();
        System.out.println("State: " + dctx.state());

        System.out.println("\n== Template Method ==");
        new AuditReportTemplate().generate(rc);

        System.out.println("\n== Observer ==");
        EventBus bus = new EventBus();
        bus.on("user:registered", (e, p) -> System.out.println("Email: welcome " + p));
        bus.on("user:registered", (e, p) -> System.out.println("Audit: user " + p + " joined"));
        UserService usvc = new UserService(bus);
        usvc.register("carol");

        System.out.println("\n== Facade (ties a few together) ==");
        ReportFacade facade = new ReportFacade(new PdfReportCreator(), new AuditReportTemplate(), repo);
        facade.generateAndStore(rc, "doc-2");
        System.out.println("Done.");
    }
}
