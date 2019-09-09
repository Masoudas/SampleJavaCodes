package SampleJavaCodes.EventHandling;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class Example5 extends WindowAdapter{
    final private Frame frame = new Frame();
    final private Button okButton = new Button("ok");
    final private Button cancelButton = new Button("Cancel");
    final private Button applyBtn = new Button("apply");
    final private Button releaseBtn = new Button("release");  

    //final private GridBagConstraints c = new GridBagConstraints();

    public Example5(){
        frame.setSize(500, 500);
        frame.setTitle("Testing Layouts");
               
        frame.addWindowListener(this);
    }

    public void setFlowLayout(){
    // This class is used for flow layout. This will automatically align all components inside of a container.
    // Constructor is FlowLayout(align, hgap, vgap), where align is the alignment of the components inside container.
    // hgap is horizontal and vgap is the vertical gap.
        FlowLayout flowLayout = new FlowLayout(FlowLayout.RIGHT, 10, 10);
        frame.setLayout(flowLayout);

        frame.add( okButton );
        frame.add( cancelButton );
    }

    public void borderLayout(){
    // This layout has four narrow edges around called north, west, south and east, and one in the center.
        BorderLayout borderLayout = new BorderLayout();
        frame.setLayout(borderLayout);
        
        frame.add(okButton, BorderLayout.NORTH);
        frame.add(cancelButton, BorderLayout.SOUTH);
    }

    public void insetsForLayout(){
    // The insets as mentioned before returns the area which has a boundary from the actual frame.

    // The get Insets method of the class returns the Insets of the frame. It is the method that the class uses to get the insets,
    // So we should either override it (in case we inherit from the class).These idiots have written the frame class in such a way that getInsets
    // returns a clone of the Insets of the object, not the actuall thing that the class uses.

        Insets insets = frame.getInsets();
        System.out.println("bottom of insets is: " + insets.bottom + " and top is: " + insets.top);

    // Here's an example of how to override this method
    // @override public Insets getInsets(){ return new Insets(20, 10, 10, 10)}    

    // This is stupid!
    }


    public void gridLayout(){
    // Allows us to create a grid and then assign the elements inside that grid.
    // GridLayout(rows, cols, hgap, vgap), which is number of rows, columns, and h and v gaps.
        GridLayout grid = new GridLayout(4, 1, 0, 10);
        Panel panel = new Panel();
        
        frame.setLayout(grid);
                    
        frame.add(okButton);
        frame.add(panel);    // So if you want to interleave a grid, you have to send out a null reference, which you can use later.
        frame.add(cancelButton);

    }

    public void gridBagLayout() {
    // The method allows more control over the grid, as opposed to the grid layout method.
    // Each component inside the grid can be of different size, which itself would be a grid. Each subgrid is referred to as cell.
    // The constraints of the grids are called gridbag constraints. 
    // The constructor is GridBagConstraints(gridx, gridy, gridwidth, gridheight, weightx, weighty, anchor, fill, insets, ipadx, ipady).
    // gridx: The x-coordinate of the point.
    // gridy: The y-coordinate of the point. 
    // gridwidth: Specify the width of the component, in terms of cells. 
    // gridheight: Specify the height of the component, in terms of cells. 
    // weightx: Weight that determines the spacing between the horizontal components in the container. 
    // weighty: Weight that determines the spacing between the vertical components in the container.
    // anchor: Where it is anchored. For example, GridBagConstraints.CENTER, GridBagConstraints.NORTH. The top left corner of the component will be anchored.
    // fill: How the component should fill the gird. GridBagConstraints.HORIZONTAL, GridBagConstraints.VERTICAL, GridBagConstraints.BOTH, GridBagConstraints.NONE 
    // insets: The insets of the ? 
    // ipadx 
    // ipady    

    // We can use the same constraint object to add the constraints we need (should we?)
    // And the order of adding the components impact how the constraints are applied!
    
        GridBagLayout layout = new GridBagLayout();
        GridBagConstraints constraint = new GridBagConstraints();

//        constraint.anchor = GridBagConstraints.NORTH;
        constraint.gridwidth = GridBagConstraints.RELATIVE; // Sets the length of this grid. When we say relative, means continue on the same grid
        
        constraint.ipadx = 100; // This is the size of the x direction of the component relative to
        constraint.ipady = 100; // This is the size of the y direction of the component relative to

        constraint.weightx = 20;    // The x spacing of the components
        constraint.weighty = 10;    // The y spacing of the components

        constraint.gridx = 0;   // This is a sort of a coordinate system for placing the components inside the grids. Don't know it can be helpful 
        constraint.gridy = 0;

        layout.setConstraints(okButton, constraint);
        frame.add(okButton);

        constraint.gridwidth = GridBagConstraints.REMAINDER; // When we say remainder, it means terminate the grid here.
        constraint.ipadx = 100;
        constraint.ipady = 10; // This is the size of the x direction of the component relative to
        constraint.weightx = 20;    // The x spacing of the components
        constraint.weighty = 10;    // The y spacing of the components
        constraint.gridx = 1;
        constraint.gridy = 0;

        layout.setConstraints(cancelButton, constraint);
        frame.add(cancelButton);

        constraint.gridwidth = GridBagConstraints.REMAINDER; 
        constraint.ipadx = 100;
        constraint.ipady = 10;
        constraint.weightx = 5;    // The x spacing of the components
        constraint.weighty = 5;    // The y spacing of the components
        constraint.gridx = 1;
        constraint.gridy = 1;

        layout.setConstraints(applyBtn, constraint);
        frame.add(applyBtn);    

        constraint.gridwidth = GridBagConstraints.REMAINDER; // Sets the length of this grid
        constraint.ipadx = 100;
        constraint.ipady = 50;
        constraint.weightx = 0;    // The x spacing of the components
        constraint.weighty = 0;    // The y spacing of the components
        constraint.gridx = 1;
        constraint.gridy = 2;

        layout.setConstraints(releaseBtn, constraint);

        frame.setLayout(layout);
        frame.add(releaseBtn);
        
    }
    
    public void cardLayOut(){
    // The card layout allows the interface to change inside the frame. So we can have different interfaces hidden inside the same frame,
    // and when the user chooses some criteria, then a particular interface appears on the same frame.
    }
    
    public void showFrame(){
        frame.setVisible(true);

    }

    @Override
    public void windowClosing(WindowEvent e) {
        frame.setVisible(false);
        frame.dispose();
    }


    public static void main(String[] args) {
        Example5 e5 = new Example5();
        
        //e5.borderLayout();
        //e5.insetsForLayout();
        //e5.gridLayout();
        e5.gridBagLayout();
        e5.showFrame();
    }
}
