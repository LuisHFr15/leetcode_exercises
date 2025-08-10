# You are given an array of strings tokens that represents an arithmetic expression in a Reverse Polish Notation.

# Evaluate the expression. Return an integer that represents the value of the expression.

# Note that:

#     The valid operators are '+', '-', '*', and '/'.
#     Each operand may be an integer or another expression.
#     The division between two integers always truncates toward zero.
#     There will not be any division by zero.
#     The input represents a valid arithmetic expression in a reverse polish notation.
#     The answer and all the intermediate calculations can be represented in a 32-bit integer.

import math
class Solution:
    def evalRPN(self, tokens: list[str]) -> int:
        numbers_stack = []
        
        for token in tokens:
            if token not in ["+", "-", "/", "*"]:
                numbers_stack.append(int(token))
                continue
            
            first_operand = numbers_stack[-2]
            second_operand = numbers_stack[-1]
            
            if token == "+":    
                result = first_operand + second_operand
                
            elif token == "-":
                result = first_operand - second_operand
                
            elif token == "*":
                result = first_operand * second_operand
                
            else:
                result = first_operand / second_operand
                result = math.trunc(result)
                
            numbers_stack.pop()
            numbers_stack[-1] = result
            
        return numbers_stack[-1]    
        
            
            