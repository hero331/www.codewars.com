/*
https://www.codewars.com/kata/59c68ea2aeb2843e18000109

The description is rather long but it tries to explain what a financing plan is.
The fixed monthly payment for a fixed rate mortgage is the amount paid by the borrower every month that ensures that the loan is paid off in full with interest at the end of its term.
The monthly payment formula is based on the annuity formula. The monthly payment c depends upon:
rate - the monthly interest rate is expressed as a decimal, not a percentage. The monthly rate is simply the given yearly percentage rate divided by 100 and then by 12.
term - the number of monthly payments, called the loan's term.
principal - the amount borrowed, known as the loan's principal (or balance).
First we have to determine c.

We have: c = n /d with n = r * balance and d = 1 - (1 + r)**(-term) where ** is the power function (you can look at the reference below).
The payment c is composed of two parts. The first part pays the interest (let us call it int) due for the balance of the given month, the second part repays the balance (let us call this part princ) hence for the following month we get a new balance = old balance - princ with c = int + princ.
Loans are structured so that the amount of principal returned to the borrower starts out small and increases with each mortgage payment. While the mortgage payments in the first years consist primarily of interest payments, the payments in the final years consist primarily of principal repayment.
A mortgage's amortization schedule provides a detailed look at precisely what portion of each mortgage payment is dedicated to each component.

In an example of a $100,000, 30-year mortgage with a rate of 6 percents the amortization schedule consists of 360 monthly payments. The partial amortization schedule below shows with 2 decimal floats the balance between principal and interest payments.

--	num_payment	c	princ	int	Balance
--	1	599.55	99.55	500.00	99900.45
--	...	599.55	...	...	...
--	12	599.55	105.16	494.39	98,771.99
--	...	599.55	...	...	...
--	360	599.55	596.57	2.98	0.00
Task:
Given parameters

rate: annual rate as percent (don't forgent to divide by 100*12)
bal: original balance (borrowed amount) 
term: number of monthly payments
num_payment: rank of considered month (from 1 to term)
the function amort will return a formatted string (for example):

"num_payment %d c %.0f princ %.0f int %.0f balance %.0f" (with arguments num_payment, c, princ, int, balance)

In Common Lisp: return a list with num-payment, c, princ, int, balance each rounded.

Examples:
amort(6, 100000, 360, 1) ->
"num_payment 1 c 600 princ 100 int 500 balance 99900"

amort(6, 100000, 360, 12) ->
"num_payment 12 c 600 princ 105 int 494 balance 98772"
Ref
https://en.wikipedia.org/wiki/Mortgage_calculator
*/
public class cd23 {
    public static void main(String args[]){
        System.out.println(amort(6.5, 200000, 360, 1));
        System.out.println(amort(6, 100000, 360, 1));
        System.out.println(amort(6, 100000, 360, 359));
    }

    public static String amort(double rate, double bal, int term, int num_payment){
        double r=rate/100/12;
        long c=Math.round((r*bal)/(1-Math.pow(1+r,-1*term)));
        long balance=Math.round((Math.pow(1+r,num_payment)*bal)-((Math.pow(1+r,num_payment)-1)/r)*c);
        long i=Math.round((((bal*r)-c)*((Math.pow(1+r,num_payment)-1)/r))+(c*num_payment));
        long princ=c-i;
        
        return "num_payment "+num_payment+" c "+c+" princ "+princ+" int "+i+" balance "+balance;
    }
}
