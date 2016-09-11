package com.beauchef.jvm.memory;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

/**
 * @author beauchef 9/10/2016.
 */
public class Sawtooth {

    private static Unsafe unsafe;
    static {
        try {
            Field field = Unsafe.class.getDeclaredField("theUnsafe");
            field.setAccessible(true);
            unsafe = (Unsafe)field.get(null);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static long addressOf(Object o) {
        Object[] array = new Object[]{o};
        long baseOffset = unsafe.arrayBaseOffset(Object[].class);
        int addressSize = unsafe.addressSize();
        long objectAddress;
        switch (addressSize) {
            case 4:
                objectAddress = unsafe.getInt(array, baseOffset);
                break;
            case 8:
                objectAddress = unsafe.getLong(array, baseOffset);
                break;
            default:
                throw new RuntimeException("Unsupported address size: " + addressSize);
        }
        return objectAddress;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 32_000; i++) {
            Object mine = new GCMe();
            long address = addressOf(mine);
            System.out.println(address);
        }
    }
}
