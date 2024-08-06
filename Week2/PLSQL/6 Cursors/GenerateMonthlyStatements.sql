DECLARE
    CURSOR cur_transactions IS
        SELECT DISTINCT c.CustomerID, c.Name
        FROM Customers c
        JOIN Accounts a ON c.CustomerID = a.CustomerID
        JOIN Transactions t ON a.AccountID = t.AccountID
        WHERE t.TransactionDate >= TRUNC(SYSDATE, 'MM') 
          AND t.TransactionDate < ADD_MONTHS(TRUNC(SYSDATE, 'MM'), 1);

    TYPE transaction_record IS RECORD (
        CustomerID Customers.CustomerID%TYPE,
        Name Customers.Name%TYPE
    );
    
    v_transaction transaction_record;
    
    CURSOR cur_customer_transactions (p_customer_id NUMBER) IS
        SELECT t.TransactionDate, t.Amount, t.TransactionType
        FROM Transactions t
        JOIN Accounts a ON t.AccountID = a.AccountID
        WHERE a.CustomerID = p_customer_id
          AND t.TransactionDate >= TRUNC(SYSDATE, 'MM') 
          AND t.TransactionDate < ADD_MONTHS(TRUNC(SYSDATE, 'MM'), 1);

BEGIN
    FOR v_transaction IN cur_transactions LOOP
        DBMS_OUTPUT.PUT_LINE('Statement for Customer: ' || v_transaction.Name || ' (ID: ' || v_transaction.CustomerID || ')');
        
        FOR v_customer_transaction IN cur_customer_transactions(v_transaction.CustomerID) LOOP
            DBMS_OUTPUT.PUT_LINE('Date: ' || v_customer_transaction.TransactionDate || 
                                 ', Amount: ' || v_customer_transaction.Amount || 
                                 ', Type: ' || v_customer_transaction.TransactionType);
        END LOOP;
        
        DBMS_OUTPUT.PUT_LINE('-----------------------------------------');
    END LOOP;
END;
/
