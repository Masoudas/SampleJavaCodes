/**
 * Sometimes when we create a window, we want to have several dialogs to be
 * opened from inside that window. For this end, we can use modal windows.
 *
 * This is very useful when we want to gather additional information in the same
 * window.
 * 
 * So Java provides a dialog object, and we have the following dialog types,
 * which we can provide as input types for the dialog:
 * 
 * 1- Dialog box — A top-level pop-up window with a title and a border that
 *      typically takes some form of input from the user. A dialog box can be modal
 *      or modeless. For more information about dialog boxes, see An Overview of
 *      Dialogs in the How to Make Dialogs page. 
 * 
 * 2- Modal dialog box — A dialog box that blocks input to some other top-level 
 *      windows in the application, except for windows created with the dialog box 
 *      as their owner. The modal dialog box captures the window focus until it is 
 *      closed, usually in response to a button press. 
 * 
 * 3- Modeless dialog box — A dialog box that enables you to operate with
 *      other windows while this dialog box is shown.
 * 
 * The behavior of both modal and modeless dialog boxes is defined so that 
 * they always appear on top of both not only of their parent windows and of 
 * all blocked windows as well.
 * 
 * To block parent windows, sometimes we want to block all windows of the same
 * owner, of the same application, or the same toolkit. 
 * Hence, we have the following modal types:
 * 1- Modeless type — A modeless dialog box does not block any other window 
*       while it is visible.
   2- Document-modal type — A document-modal dialog box blocks all windows 
        from the same document, except windows from its child hierarchy. 
        In this context, a document is a hierarchy of windows that share a common ancestor, 
        called the document root, which is the closest ancestor window without an owner.
   3- Application-modal type — An application-modal dialog box blocks all windows from 
        the same application, except windows from its child hierarchy. 
        If several applets are launched in a browser environment, the browser is allowed 
        to treat them either as separate applications or as a single application. 
        This behavior is implementation-dependent.
   4- Toolkit-modal type — A toolkit-modal dialog box blocks all windows that run in 
        the same toolkit, except windows from its child hierarchy. If several applets 
        are launched, all of them run with the same toolkit. Hence, a toolkit-modal 
        dialog box shown from an applet may affect other applets and all windows 
        of the browser instance that embeds the Java runtime environment for this toolkit.

    We also have:
        Exclusion mode — Any top-level window can be marked not to be blocked by modal dialogs. 
        This property enables you to set up the modal exclusion mode. 
        The Dialog.ModalExclusionType enum specifies the possible modal exclusion types.
 */