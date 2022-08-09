/*
 * Copyright LWJGL. All rights reserved.
 * License terms: https://www.lwjgl.org/license
 * MACHINE GENERATED FILE, DO NOT EDIT
 */
package org.lwjgl.openxr;

import org.jetbrains.annotations.Nullable;
import org.lwjgl.BufferUtils;
import org.lwjgl.system.*;

import java.nio.ByteBuffer;

import static org.lwjgl.openxr.FBHandTrackingCapsules.XR_FB_HAND_TRACKING_CAPSULE_COUNT;
import static org.lwjgl.system.Checks.check;
import static org.lwjgl.system.MemoryUtil.*;

/**
 * <h3>Layout</h3>
 * 
 * <pre><code>
 * struct XrHandTrackingCapsulesStateFB {
 *     XrStructureType type;
 *     void * next;
 *     {@link XrHandCapsuleFB XrHandCapsuleFB} capsules[XR_FB_HAND_TRACKING_CAPSULE_COUNT];
 * }</code></pre>
 */
public class XrHandTrackingCapsulesStateFB extends Struct implements NativeResource {

    /** The struct size in bytes. */
    public static final int SIZEOF;

    /** The struct alignment in bytes. */
    public static final int ALIGNOF;

    /** The struct member offsets. */
    public static final int
        TYPE,
        NEXT,
        CAPSULES;

    static {
        Layout layout = __struct(
            __member(4),
            __member(POINTER_SIZE),
            __array(XrHandCapsuleFB.SIZEOF, XrHandCapsuleFB.ALIGNOF, XR_FB_HAND_TRACKING_CAPSULE_COUNT)
        );

        SIZEOF = layout.getSize();
        ALIGNOF = layout.getAlignment();

        TYPE = layout.offsetof(0);
        NEXT = layout.offsetof(1);
        CAPSULES = layout.offsetof(2);
    }

    /**
     * Creates a {@code XrHandTrackingCapsulesStateFB} instance at the current position of the specified {@link ByteBuffer} container. Changes to the buffer's content will be
     * visible to the struct instance and vice versa.
     *
     * <p>The created instance holds a strong reference to the container object.</p>
     */
    public XrHandTrackingCapsulesStateFB(ByteBuffer container) {
        super(memAddress(container), __checkContainer(container, SIZEOF));
    }

    @Override
    public int sizeof() { return SIZEOF; }

    /** @return the value of the {@code type} field. */
    @NativeType("XrStructureType")
    public int type() { return ntype(address()); }
    /** @return the value of the {@code next} field. */
    @NativeType("void *")
    public long next() { return nnext(address()); }
    /** @return a {@link XrHandCapsuleFB}.Buffer view of the {@code capsules} field. */
    @NativeType("XrHandCapsuleFB[XR_FB_HAND_TRACKING_CAPSULE_COUNT]")
    public XrHandCapsuleFB.Buffer capsules() { return ncapsules(address()); }
    /** @return a {@link XrHandCapsuleFB} view of the struct at the specified index of the {@code capsules} field. */
    public XrHandCapsuleFB capsules(int index) { return ncapsules(address(), index); }

    /** Sets the specified value to the {@code type} field. */
    public XrHandTrackingCapsulesStateFB type(@NativeType("XrStructureType") int value) { ntype(address(), value); return this; }
    /** Sets the {@link FBHandTrackingCapsules#XR_TYPE_HAND_TRACKING_CAPSULES_STATE_FB TYPE_HAND_TRACKING_CAPSULES_STATE_FB} value to the {@code type} field. */
    public XrHandTrackingCapsulesStateFB type$Default() { return type(FBHandTrackingCapsules.XR_TYPE_HAND_TRACKING_CAPSULES_STATE_FB); }
    /** Sets the specified value to the {@code next} field. */
    public XrHandTrackingCapsulesStateFB next(@NativeType("void *") long value) { nnext(address(), value); return this; }

    /** Initializes this struct with the specified values. */
    public XrHandTrackingCapsulesStateFB set(
        int type,
        long next
    ) {
        type(type);
        next(next);

        return this;
    }

    /**
     * Copies the specified struct data to this struct.
     *
     * @param src the source struct
     *
     * @return this struct
     */
    public XrHandTrackingCapsulesStateFB set(XrHandTrackingCapsulesStateFB src) {
        memCopy(src.address(), address(), SIZEOF);
        return this;
    }

    // -----------------------------------

    /** Returns a new {@code XrHandTrackingCapsulesStateFB} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed. */
    public static XrHandTrackingCapsulesStateFB malloc() {
        return wrap(XrHandTrackingCapsulesStateFB.class, nmemAllocChecked(SIZEOF));
    }

    /** Returns a new {@code XrHandTrackingCapsulesStateFB} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed. */
    public static XrHandTrackingCapsulesStateFB calloc() {
        return wrap(XrHandTrackingCapsulesStateFB.class, nmemCallocChecked(1, SIZEOF));
    }

    /** Returns a new {@code XrHandTrackingCapsulesStateFB} instance allocated with {@link BufferUtils}. */
    public static XrHandTrackingCapsulesStateFB create() {
        ByteBuffer container = BufferUtils.createByteBuffer(SIZEOF);
        return wrap(XrHandTrackingCapsulesStateFB.class, memAddress(container), container);
    }

    /** Returns a new {@code XrHandTrackingCapsulesStateFB} instance for the specified memory address. */
    public static XrHandTrackingCapsulesStateFB create(long address) {
        return wrap(XrHandTrackingCapsulesStateFB.class, address);
    }

    /** Like {@link #create(long) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    @Nullable
    public static XrHandTrackingCapsulesStateFB createSafe(long address) {
        return address == NULL ? null : wrap(XrHandTrackingCapsulesStateFB.class, address);
    }

    /**
     * Returns a new {@link Buffer} instance allocated with {@link MemoryUtil#memAlloc memAlloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static Buffer malloc(int capacity) {
        return wrap(Buffer.class, nmemAllocChecked(__checkMalloc(capacity, SIZEOF)), capacity);
    }

    /**
     * Returns a new {@link Buffer} instance allocated with {@link MemoryUtil#memCalloc memCalloc}. The instance must be explicitly freed.
     *
     * @param capacity the buffer capacity
     */
    public static Buffer calloc(int capacity) {
        return wrap(Buffer.class, nmemCallocChecked(capacity, SIZEOF), capacity);
    }

    /**
     * Returns a new {@link Buffer} instance allocated with {@link BufferUtils}.
     *
     * @param capacity the buffer capacity
     */
    public static Buffer create(int capacity) {
        ByteBuffer container = __create(capacity, SIZEOF);
        return wrap(Buffer.class, memAddress(container), capacity, container);
    }

    /**
     * Create a {@link Buffer} instance at the specified memory.
     *
     * @param address  the memory address
     * @param capacity the buffer capacity
     */
    public static Buffer create(long address, int capacity) {
        return wrap(Buffer.class, address, capacity);
    }

    /** Like {@link #create(long, int) create}, but returns {@code null} if {@code address} is {@code NULL}. */
    @Nullable
    public static XrHandTrackingCapsulesStateFB.Buffer createSafe(long address, int capacity) {
        return address == NULL ? null : wrap(Buffer.class, address, capacity);
    }


    /**
     * Returns a new {@code XrHandTrackingCapsulesStateFB} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack the stack from which to allocate
     */
    public static XrHandTrackingCapsulesStateFB malloc(MemoryStack stack) {
        return wrap(XrHandTrackingCapsulesStateFB.class, stack.nmalloc(ALIGNOF, SIZEOF));
    }

    /**
     * Returns a new {@code XrHandTrackingCapsulesStateFB} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack the stack from which to allocate
     */
    public static XrHandTrackingCapsulesStateFB calloc(MemoryStack stack) {
        return wrap(XrHandTrackingCapsulesStateFB.class, stack.ncalloc(ALIGNOF, 1, SIZEOF));
    }

    /**
     * Returns a new {@link Buffer} instance allocated on the specified {@link MemoryStack}.
     *
     * @param stack    the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static Buffer malloc(int capacity, MemoryStack stack) {
        return wrap(Buffer.class, stack.nmalloc(ALIGNOF, capacity * SIZEOF), capacity);
    }

    /**
     * Returns a new {@link Buffer} instance allocated on the specified {@link MemoryStack} and initializes all its bits to zero.
     *
     * @param stack    the stack from which to allocate
     * @param capacity the buffer capacity
     */
    public static Buffer calloc(int capacity, MemoryStack stack) {
        return wrap(Buffer.class, stack.ncalloc(ALIGNOF, capacity, SIZEOF), capacity);
    }

    // -----------------------------------

    /** Unsafe version of {@link #type}. */
    public static int ntype(long struct) { return UNSAFE.getInt(null, struct + XrHandTrackingCapsulesStateFB.TYPE); }
    /** Unsafe version of {@link #next}. */
    public static long nnext(long struct) { return memGetAddress(struct + XrHandTrackingCapsulesStateFB.NEXT); }
    /** Unsafe version of {@link #capsules}. */
    public static XrHandCapsuleFB.Buffer ncapsules(long struct) { return XrHandCapsuleFB.create(struct + XrHandTrackingCapsulesStateFB.CAPSULES, XR_FB_HAND_TRACKING_CAPSULE_COUNT); }
    /** Unsafe version of {@link #capsules(int) capsules}. */
    public static XrHandCapsuleFB ncapsules(long struct, int index) {
        return XrHandCapsuleFB.create(struct + XrHandTrackingCapsulesStateFB.CAPSULES + check(index, XR_FB_HAND_TRACKING_CAPSULE_COUNT) * XrHandCapsuleFB.SIZEOF);
    }

    /** Unsafe version of {@link #type(int) type}. */
    public static void ntype(long struct, int value) { UNSAFE.putInt(null, struct + XrHandTrackingCapsulesStateFB.TYPE, value); }
    /** Unsafe version of {@link #next(long) next}. */
    public static void nnext(long struct, long value) { memPutAddress(struct + XrHandTrackingCapsulesStateFB.NEXT, value); }

    // -----------------------------------

    /** An array of {@link XrHandTrackingCapsulesStateFB} structs. */
    public static class Buffer extends StructBuffer<XrHandTrackingCapsulesStateFB, Buffer> implements NativeResource {

        private static final XrHandTrackingCapsulesStateFB ELEMENT_FACTORY = XrHandTrackingCapsulesStateFB.create(-1L);

        /**
         * Creates a new {@code XrHandTrackingCapsulesStateFB.Buffer} instance backed by the specified container.
         *
         * Changes to the container's content will be visible to the struct buffer instance and vice versa. The two buffers' position, limit, and mark values
         * will be independent. The new buffer's position will be zero, its capacity and its limit will be the number of bytes remaining in this buffer divided
         * by {@link XrHandTrackingCapsulesStateFB#SIZEOF}, and its mark will be undefined.
         *
         * <p>The created buffer instance holds a strong reference to the container object.</p>
         */
        public Buffer(ByteBuffer container) {
            super(container, container.remaining() / SIZEOF);
        }

        public Buffer(long address, int cap) {
            super(address, null, -1, 0, cap, cap);
        }

        Buffer(long address, @Nullable ByteBuffer container, int mark, int pos, int lim, int cap) {
            super(address, container, mark, pos, lim, cap);
        }

        @Override
        protected Buffer self() {
            return this;
        }

        @Override
        protected XrHandTrackingCapsulesStateFB getElementFactory() {
            return ELEMENT_FACTORY;
        }

        /** @return the value of the {@code type} field. */
        @NativeType("XrStructureType")
        public int type() { return XrHandTrackingCapsulesStateFB.ntype(address()); }
        /** @return the value of the {@code next} field. */
        @NativeType("void *")
        public long next() { return XrHandTrackingCapsulesStateFB.nnext(address()); }
        /** @return a {@link XrHandCapsuleFB}.Buffer view of the {@code capsules} field. */
        @NativeType("XrHandCapsuleFB[XR_FB_HAND_TRACKING_CAPSULE_COUNT]")
        public XrHandCapsuleFB.Buffer capsules() { return XrHandTrackingCapsulesStateFB.ncapsules(address()); }
        /** @return a {@link XrHandCapsuleFB} view of the struct at the specified index of the {@code capsules} field. */
        public XrHandCapsuleFB capsules(int index) { return XrHandTrackingCapsulesStateFB.ncapsules(address(), index); }

        /** Sets the specified value to the {@code type} field. */
        public Buffer type(@NativeType("XrStructureType") int value) { XrHandTrackingCapsulesStateFB.ntype(address(), value); return this; }
        /** Sets the {@link FBHandTrackingCapsules#XR_TYPE_HAND_TRACKING_CAPSULES_STATE_FB TYPE_HAND_TRACKING_CAPSULES_STATE_FB} value to the {@code type} field. */
        public Buffer type$Default() { return type(FBHandTrackingCapsules.XR_TYPE_HAND_TRACKING_CAPSULES_STATE_FB); }
        /** Sets the specified value to the {@code next} field. */
        public Buffer next(@NativeType("void *") long value) { XrHandTrackingCapsulesStateFB.nnext(address(), value); return this; }

    }

}