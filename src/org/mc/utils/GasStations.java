package org.mc.utils;

public class GasStations {
    public int chooseStartStation(int[] gas, int[] cost) {
        int totalCost = sum(cost);
        int totalGas = sum(gas);

        if (totalCost > totalGas)
            return (-1);

        int minGasStation = -1;
        int minGas = Integer.MAX_VALUE;

        // lets make a ride with full tank
        // and find a station where fuel level will be lowest.
        // if we start from that station we will be able to
        // finish our ride

        int currentGasLevel = totalGas;
        for (int i = 0; i < gas.length; i++) {
            if (currentGasLevel < minGas) {
                minGas = currentGasLevel;
                minGasStation = i;
            }

            currentGasLevel += (gas[i] - cost[i]);
        }

        return minGasStation;
    }

    private int sum(int[] array) {
        int total = 0;
        for(int item : array) total += item;
        return total;
    }
}
