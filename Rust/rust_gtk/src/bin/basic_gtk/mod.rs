use gtk::*;
use std::process;

pub struct App {
    pub window: Window,
    pub header: Header,
}

pub struct Header {
    pub container: HeaderBar
}

/*
Each GtkWidget provides a get_style_context() method, which returns an Option,
which thereby provides an add_class() method, which is then used to set style
classes. Got it? Good. The most important classes to know for buttons are the
destructive-action and suggested-action buttons. Typically, a destructive action
sets the button to a red color, while the suggested action uses a blue color. The
actual color will depend upon which GTK theme that the user is using, though.
*/
fn create_buttons() {
    let text_button = Button::new_with_label("Ok");
    let image_button = Button::new_from_icon_name("icon-name", 32);
    text_button.get_style_context().map(|c| c.add_class("destructive-action"));
    image_button.get_style_context().map(|c| c.add_class("suggested-action"));
}

fn create_labels() {
    let information_label = Label::new("Specific Information: ");
    let value = Label::new("Linux");
    value.set_label("Redox");

    let horizontal_box = Box::new(Orientation::Horizontal, 5);
    horizontal_box.pack_start(&information_label, false, false, 0);
    horizontal_box.pack_start(&value, true, false, 0);
}

impl App {
    fn new() -> App {
        // Create a new top level window.
        let window = Window::new(WindowType::Toplevel);
        // Create a the headerbar and it's associated content.
        let header = Header::new();

        // Set the headerbar as the title bar widget.
        window.set_titlebar(&header.container);
        // Set the title of the window.
        window.set_title("App Name");
        // Set the window manager class.
        window.set_wmclass("app-name", "App name");
        // The icon the app will display.
        Window::set_default_icon_name("iconname");

        // Programs what to do when the exit button is used.
        window.connect_delete_event(move |_, _| {
            main_quit();
            Inhibit(false)
        });

        // Return our main application state
        App { window, header }
    }
}

impl Header {
    fn new() -> Header {
        // Creates the main header bar container widget.
        let container = HeaderBar::new();

        // Sets the text to display in the title section of the header bar.
        container.set_title("App Name");
        // Enable the window controls within this headerbar.
        container.set_show_close_button(true);

        // Returns the header and all of it's state
        Header { container }
    }
}

pub fn run_basic_gtk() {

    // Initialize GTK before proceeding.
    if gtk::init().is_err() {
        eprintln!("failed to initialize GTK Application");
        process::exit(1);
    }

    // Initialize the UI's initial state
    let app = App::new();

    // Make all the widgets within the UI visible.
    app.window.show_all();

    // Start the GTK main event loop
    gtk::main();
}
