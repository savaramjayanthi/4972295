DECLARE
    CURSOR c_customers IS
        SELECT c.CustomerID, l.LoanID, l.InterestRate
        FROM Customers c
        JOIN Loans l ON c.CustomerID = l.CustomerID
        WHERE EXTRACT(YEAR FROM SYSDATE) - EXTRACT(YEAR FROM c.DOB) > 60;

    v_CustomerID Customers.CustomerID%TYPE;
    v_LoanID Loans.LoanID%TYPE;
    v_InterestRate Loans.InterestRate%TYPE;
BEGIN
    OPEN c_customers;
    LOOP
        FETCH c_customers INTO v_CustomerID, v_LoanID, v_InterestRate;
        EXIT WHEN c_customers%NOTFOUND;

        -- Apply a 1% discount
        v_InterestRate := v_InterestRate - 1;

        -- Update the loan's interest rate
        UPDATE Loans
        SET InterestRate = v_InterestRate
        WHERE LoanID = v_LoanID;
    END LOOP;
    CLOSE c_customers;
    COMMIT;
END;
/
