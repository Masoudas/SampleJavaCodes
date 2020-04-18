/**
 * We know that what this rule implies. An example of disasterous behavior
 * is the Point and dimension classes in AWT, which has caused huge problems.
 * 
 * Note however that exceptions may occur. For example, if a class is package
 * private, we can expose the global fields, to avoid cluttering of information
 * when we read the code.
 */