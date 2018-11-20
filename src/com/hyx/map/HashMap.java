package com.hyx.map;

public class HashMap<K,V> implements Map<K,V> {
	private static int defaultLength=16;
	private static double defaultLoader=0.75;
	
	private Entry<K, V>[] table=null;
	
	private int size=0;
	
	
	public HashMap(int length,double loader) {
		defaultLength = length;
		defaultLoader = loader;
		table = new Entry[defaultLength];
	}
	
	public HashMap() {
		this(defaultLength, defaultLoader);
	}
	
	public Entry<K,V> newEntry(K k,V v,Entry<K,V> next){
		return new Entry<K,V>(k,v,next);
	}

	public V put(K k,V v) {
		size ++;
		int index = hash(k);
		
		Entry<K,V> entry = table[index];
		if(entry == null) {
			table[index] = newEntry(k,v,null);
		}
		else {
			table[index] = newEntry(k,v,entry);
		}
		return table[index].getValue();
	} 
	
	
	public V get(K k) {
		int index = hash(k);
		if(table[index] == null) {
			return null;
		}
		else {
			return find(k,table[index]);
		}
	}
	
	private V find(K k,Entry<K,V> entry) {
		if(k==entry.getKey() || k.equals(entry.getKey())) {
			return entry.getValue();
		}
		else {
			if(entry.next != null) {
				return find(k,entry);
			}
		}
		return null;
	}
	
	public int hash(K k) {
		int m = defaultLength;
		int i = k.hashCode() % m;
		return i >= 0?i:-i;
	}
	
	public int size() {
		return size;
	}
	

	class Entry<K,V> implements Map.Entry<K, V>{

		K k;
		V v;
		
		Entry<K,V> next;
		
		public Entry(K k, V v, Entry<K, V> next) {
			this.k = k;
			this.v = v;
			this.next = next;
		}

		public Entry<K, V> getNext() {
			return next;
		}

		public void setNext(Entry<K, V> next) {
			this.next = next;
		}

		@Override
		public K getKey() {
			// TODO Auto-generated method stub
			return k;
		}

		@Override
		public V getValue() {
			// TODO Auto-generated method stub
			return v;
		}
		
	}
}
