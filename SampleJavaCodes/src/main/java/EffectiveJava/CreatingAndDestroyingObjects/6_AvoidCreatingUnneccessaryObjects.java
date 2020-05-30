package EffectiveJava.CreatingAndDestroyingObjects;

/**
 * As we know, not creating objects is an advantage. But consider this. The Map
 * classes, when we ask for the keyset, return the same key set for all
 * instances. Why? Because they supposed that the same set is supported by the
 * map instance, hence why create new ones. Of course this risks addition to the
 * set, but why not? Also, as we know, flyweight style patterns (and object
 * pools) are usually a terrible idea and should be avoided at all cost.
 */