package SwingLibrary.LayoutManagers;

/**
 * The anchor constraint tells where a component should be placed if its size is
 * smaller than the cell it occupies. It has many options, like north, south and
 * others. Of course, fill should be set to NONE.
 * 
 * Also, PAGE_START, PAGE_END, LINE_START, LINE_END, FIRST_LINE_START,
 * FIRST_LINE_END, LAST_LINE_START, and LAST_LINE_END
 * 
 * There's also a The baseline-base anchor’s values are used when you want to
 * align the components in a row along their baseline. What is the baseline of a
 * component? The baseline is relative to text. It is an imaginary line on which
 * the characters of the text rest (See the photo of this example). You can get
 * the baseline value for a component by using its getBaseline(int width, int
 * height) method. Note that you need to pass the width and height of the
 * component to get its baseline. Not all components have base lines. The
 * constains for the anchor then would be BASLINE, BASELINE_LEADING, or
 * BASELINE_TRAILING.
 */