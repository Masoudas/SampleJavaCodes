package SwingLibrary.components_5.ScrollBarComponents_8;

import javax.swing.JScrollBar;

/**
 * Rarely used, because so much code is needed for when the component is greater
 * that display area.
 * 
 * Used when the space available is not enough to show all components. It has
 * orientation property, horizontal or vertical. A JScrollbar has a knob (the
 * thing that moves), two arrows, and a track.
 * 
 * The constructor can be passed several values from the params:
 * 
 * value indicates the position of the knob of the scrollbar.
 * 
 * extent (also using setVisibleAmount): It is the size of the knob. It is
 * expressed in proportion to the size of the track. For example, if the track
 * size represents 150 and you set the extent to 25, the knob size will be one
 * sixth of the track size. Its default value is 10.
 * 
 * min and max: the min and max. Default is zero and 100.
 * 
 * addAdjustmentListener method is used for when the value changes.
 */
class ScrollBarExample {
    public static void main(String[] args) {
        JScrollBar scrollBar = new JScrollBar(JScrollBar.HORIZONTAL, 10, 25, 0, 150);
    }
}