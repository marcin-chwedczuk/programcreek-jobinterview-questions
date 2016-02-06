package org.mc.utils;

import sun.plugin.dom.exception.InvalidStateException;

public class IntPriorityQueue {
    private static final int INITIAL_SIZE = 8;

    // element 0 will be used as sentinel
    private int[] _storage;
    private int _elementsCount;

    public IntPriorityQueue() {
        _storage = new int[]  { Integer.MIN_VALUE };
        _elementsCount = 0;

        ensureStorage(INITIAL_SIZE);
    }

    private void resize(int newSize) {
        int[] newStorage = new int[newSize];

        int copyLength = Math.min(newSize, _storage.length);
        System.arraycopy(_storage, 0, newStorage, 0, copyLength);

        _storage = newStorage;
    }

    private void ensureStorage(int requiredSize) {
        if (requiredSize < _storage.length)
            return;

        int biggerSize = nextStorageSize(requiredSize);
        resize(biggerSize);
   }

    private int nextStorageSize(int requiredSize) {
        int size = _storage.length;

        while (size <= requiredSize)
            size *= 2;

        return size;
    }

    private void tryShrinkStorage() {
        int smallerSize = prevStorageSize();
        if (smallerSize == _storage.length)
            return;

        resize(smallerSize);
    }

    private int prevStorageSize() {
        int size = _storage.length;

        if (size > (4*_elementsCount))
            size /= 2;

        return Math.max(INITIAL_SIZE, size);
    }

    public int elementsCount() {
        return _elementsCount;
    }

    public void insert(int value) {
        ensureStorage(_elementsCount+1);

        _elementsCount++;
        _storage[_elementsCount] = value;
        upheap(_elementsCount);
    }

    private void upheap(int index) {
        while (_storage[index/2] > _storage[index]) {
            int parent = index / 2;

            int tmp = _storage[parent];
            _storage[parent] = _storage[index];
            _storage[index] = tmp;

            index = parent;
        }
    }

    public int peek() {
        if (_elementsCount == 0)
            throw new InvalidStateException("Queue is empty.");

        return _storage[1];
    }

    public int deleteMin() {
        if (_elementsCount == 0)
            throw new InvalidStateException("Queue is empty.");

        int min = _storage[1];

        _storage[1] = _storage[_elementsCount];
        _elementsCount--;
        downheap(1);

        tryShrinkStorage();
        return min;
    }

    private void downheap(int index) {
        int left = index*2;
        int right = index*2 + 1;

        while (left <= _elementsCount) {
            int min = left;

            if (right <= _elementsCount && _storage[left] > _storage[right])
                min = right;

            if (_storage[index] < _storage[min])
                break;

            int tmp = _storage[index];
            _storage[index] = _storage[min];
            _storage[min] = tmp;

            index = min;
            left = 2*min;
            right = 2*min+1;
        }
    }
}
