/**
 * If a class is accessible by only one member, then it should be private, or an
 * static part of that class (which I don't agree with). If classes are properly
 * separated, then when profiled at the end, we can see which ones are causing
 * performance issues, and we can eliminate them.
 * 
 * We always start at the lowest level of accessability (private). Then we
 * increase it (either protected or package level by not adding any access
 * modifiers), and finally public.
 * 
 * Note that even a member is protected, it is exported as part of the API, and
 * we are forever committed to implementing it. Hence, don't expose material
 * unless you absolutely have to.
 * 
 * A class generally should not expose any fields. It may expose final static
 * primitive types. It, under very rare circumestances, can expose immutable
 * types. However, the problem with the latter is that the underlying references
 * of the immutable can be mutable.
 * 
 * We never export arrays! Or have methods that return arrays directly.
 * Eventhough the reference may be final, the content can change.
 * 
 * If a private field has to be returned through an accesser method, either
 * return a copy of it, or make it immutable.
 * 
 * Finally, note that classes with public mutuable classes are not generally
 * thread safe.
 */