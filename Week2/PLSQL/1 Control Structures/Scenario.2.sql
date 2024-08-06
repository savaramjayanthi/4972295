DECLARE
    CURSOR c_customers IS
        SELECT CustomerID, Balance
        FROM Customers
        WHERE Balance > 10000;

    v_CustomerID Customers.CustomerID%TYPE;
    v_Balance Customers.Balance%TYPE;
BEGIN
    OPEN c_customers;
    LOOP
        FETCH c_customers INTO v_CustomerID, v_Balance;
        EXIT WHEN c_customers%NOTFOUND;

        -- Set the IsVIP flag to TRUE
        UPDATE Customers
        SET IsVIP = 'TRUE'
        WHERE CustomerID = v_CustomerID;
    END LOOP;
    CLOSE c_customers;
    COMMIT;
END;
/
