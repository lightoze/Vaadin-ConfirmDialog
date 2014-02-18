package org.vaadin.dialogs.test;

import org.vaadin.dialogs.ConfirmDialog;

import com.vaadin.server.VaadinRequest;
import com.vaadin.ui.Button;
import com.vaadin.ui.Button.ClickEvent;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.Notification;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;

@SuppressWarnings("serial")
public class ConfirmDialogTestUI extends UI {

    public static final String MESSAGE_1 = "This is the question?";
    private VerticalLayout root;

    @Override
    protected void init(VaadinRequest request) {
        getPage().setTitle("Example and test application");
        setContent(root = new VerticalLayout());
        Label label = new Label("Hello Vaadin user");
        addComponent(label);
        addBasicExample();

    }

    private void addComponent(Component c) {
        root.addComponent(c);
    }

    private void addBasicExample() {
        Button button = new Button("Basic");
        button.setId("basic");
        button.addClickListener(new Button.ClickListener() {
            public void buttonClick(ClickEvent event) {
                // The quickest way to confirm
                ConfirmDialog.show(getUI(), MESSAGE_1,
                        new ConfirmDialog.Listener() {

                            public void onClose(ConfirmDialog dialog) {
                                if (dialog.isConfirmed()) {
                                    Notification.show("Confirmed:"
                                            + dialog.isConfirmed());
                                } else {
                                    Notification.show("Confirmed:"
                                            + dialog.isConfirmed());
                                }
                            }
                        });
            }
        });
        addComponent(button);
    }

}