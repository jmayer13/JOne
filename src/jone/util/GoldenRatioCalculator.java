/*- 
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *                    Version 2, December 2004
 *
 * Copyright (C) 2004 Sam Hocevar <sam@hocevar.net>
 *
 * Everyone is permitted to copy and distribute verbatim or modified
 * copies of this license document, and changing it is allowed as long
 * as the name is changed.
 *
 *            DO WHAT THE FUCK YOU WANT TO PUBLIC LICENSE
 *   TERMS AND CONDITIONS FOR COPYING, DISTRIBUTION AND MODIFICATION
 *
 *  0. You just DO WHAT THE FUCK YOU WANT TO.
 */
package jone.util;

/**
 * Use the golden ratio to calculate proportions
 *
 * @see
 * @author Jonas Mayer (jonas.mayer.developer@gmail.com)
 */
public class GoldenRatioCalculator {

    /**
     * Get biggest size relative to a give size.
     *
     * @param size smaller size
     * @return <code>double</code> biggest size
     */
    public static double getBiggerSize(double size) {
        return size * 1.618034;
    }//end of the method getBiggerSize

    /**
     * Get biggest size of a give size.
     *
     * @param size smaller size
     * @param proportion proportion bigger/smaller
     * @return <code>double</code> biggest size
     */
    public static double getBiggerSize(double size, double proportion) {
        return size * 1.618034 * proportion;
    }//end of the method getBiggerSize

    /**
     * Get smallest size of a give size.
     *
     * @param size smaller size
     * @return <code>double</code> biggest size
     */
    public static double getSmallerSize(double size) {
        return size / 1.618034;
    }//end of the method getSmallerSize

    /**
     * Get smallest size of a give size.
     *
     * @param size small size
     * @param proportion proportion bigger/smaller
     * @return <code>double</code> biggest size
     */
    public static double getSmallerSize(double size, double proportion) {
        return (size / 1.618034) / proportion;
    }//end of the method getSmallerSize

}//end of the class GoldenRatioCalculator 
