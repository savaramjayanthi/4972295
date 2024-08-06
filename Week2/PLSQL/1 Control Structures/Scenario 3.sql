DECLARE
    CURSOR c_loans IS
        SELECT l.LoanID, c.CustomerID, c.Name, l.EndDate
        FROM Loans l
        JOIN Customers c ON l.CustomerID = c.CustomerID
        WHERE l.EndDate BETWEEN SYSDATE AND SYSDATE + 30;

    v_LoanID Loans.LoanID%TYPE;
    v_CustomerID Customers.CustomerID%TYPE;
    v_Name Customers.Name%TYPE;
    v_EndDate Loans.EndDate%TYPE;
BEGIN
    OPEN c_loans;
    LOOP
        FETCH c_loans INTO v_LoanID, v_CustomerID, v_Name, v_EndDate;
        EXIT WHEN c_loans%NOTFOUND;

        -- Print a reminder message
        DBMS_OUTPUT.PUT_LINE('Reminder: Customer ' || v_Name || 
                             ' (ID: ' || v_CustomerID || '), your loan (ID: ' || v_LoanID || 
                             ') is due on ' || TO_CHAR(v_EndDate, 'DD-MON-YYYY') || '.');
    END LOOP;
    CLOSE c_loans;
END;
/
