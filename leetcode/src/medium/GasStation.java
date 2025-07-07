package medium;

public class GasStation {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        // We want to find a starting gas station index from which we can complete the full circuit without running out of gas.
        // We loop through each station and track how much gas is left in our tank as we go.

        // Step 0 (i = 0)
        // At station 0, gas is 1 and cost is 3.
        // We lose 2 units of gas, so the tank becomes -2.
        // Since the tank is negative, we cannot start from station 0.
        // So we reset the tank to 0 and move the starting index to 1.

        // Step 1 (i = 1)
        // At station 1, gas is 2 and cost is 4.
        // Again, we lose 2 units of gas. Tank becomes -2.
        // Not enough to proceed, so we reset tank and move starting index to 2.

        // Step 2 (i = 2)
        // gas = 3, cost = 5 → tank = -2 again.
        // So station 2 also cannot be the starting point.

        // Step 3 (i = 3)
        // gas = 4, cost = 1 → tank = 3.
        // Now we have some gas left, so we continue.

        // Step 4 (i = 4)
        // gas = 5, cost = 2 → tank = 6.
        // Still positive, so we can make a full circuit.
        // Total gas equals total cost, so the trip is possible.

        // time-complexity - O(n)
        // space-complexity - O(1)

        // 3 questions
        // 1. Why is it safe to discard all previous starting points once tank < 0?
        // If the tank becomes negative at index i, it means we could not even reach station i+1 from our current starting point.
        // Because of that, any station between the original start and i also won't work — if they could, we would’ve already had enough gas to reach here.
        // So we reset the tank and try starting from i+1.

        // 2. What is the time and space complexity of your solution, and can it be improved?

        // 3. What would change if the route were not circular?
        // If the route is not circular, then we don’t need to worry about wrapping around from the end to the start.
        // In that case, we can simply scan linearly from left to right and check for the longest subarray where gas[i] >= cost[i], starting from index 0.

        int n = gas.length;
        int sumOfGas = 0;
        int sumOfCost = 0;
        int tank = 0;
        int idx = 0;

        for (int i = 0; i < n; i++) {
            sumOfGas += gas[i];
            sumOfCost += cost[i];

            tank += gas[i] - cost[i];

            if (tank < 0) {
                idx = i + 1;
                tank = 0;
            }
        }

        return sumOfGas < sumOfCost ? -1 : idx;
    }
}
