/**
 * Returning a null makes the code complicated on both the development
 * and the usage front. 
 * 
 * Returning null instead of empty collections does not help in performance,
 * because:
 * 1- We can use Collections.emptySet(), Collections.emptyList()
 * and so forth.
 * 2- We can cashe an empty list, array and so forth.
 */