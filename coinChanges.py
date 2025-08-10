# // You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.

# // Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

# // You may assume that you have an infinite number of each kind of coin.

class Solution:
    def coinChange(self, coins: list[int], amount: int) -> int:
        coins_count = [amount + 1] * (amount + 1)
        coins_count[0] = 0 # to achieve value 0 we need 0 coins
        
        for quantity in range(1, amount + 1):
            for coin in coins:
                if quantity - coin >= 0:
                    coins_count[quantity] = min(coins_count[quantity], 1 + coins_count[quantity - coin])

        return coins_count[amount] if coins_count[amount] != amount + 1 else -1