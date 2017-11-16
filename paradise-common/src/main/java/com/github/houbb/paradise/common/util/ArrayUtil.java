package com.github.houbb.paradise.common.util;

/**
 * Created by houbinbin on 2017/1/10.
 */
public final class ArrayUtil {

  private ArrayUtil() {
  }

  public static boolean isEmpty(Object[] array) {
    return array == null || array.length == 0;
  }

  public static boolean isNotEmpty(Object[] array) {
    return !isEmpty(array);
  }

  public static boolean contains(Object[] array, Object objectToFind) {
    return indexOf(array, objectToFind) != -1;
  }

  public static boolean notContains(Object[] array, Object objectToFind) {
    return !contains(array, objectToFind);
  }

  public static int indexOf(Object[] array, Object objectToFind) {
    return indexOf(array, objectToFind, 0);
  }

  public static int indexOf(Object[] array, Object objectToFind, int startIndex) {
    if (array == null) {
      return -1;
    } else {
      if (startIndex < 0) {
        startIndex = 0;
      }

      int i;
      if (objectToFind == null) {
        for (i = startIndex; i < array.length; ++i) {
          if (array[i] == null) {
            return i;
          }
        }
      } else if (array.getClass().getComponentType().isInstance(objectToFind)) {
        for (i = startIndex; i < array.length; ++i) {
          if (objectToFind.equals(array[i])) {
            return i;
          }
        }
      }

      return -1;
    }
  }


}
