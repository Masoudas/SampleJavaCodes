/**
 * This baby is used for reading from files in a byte by byte
 * manner.
 * 
 * Of course this class overrides several methods of the InputStream
 * method. The reset method is not, and any attempt at that would
 * result in an exception.
 * available() method indicates how many bytes are currently available to
 * read (from the file of course, not the buffer!)
 */