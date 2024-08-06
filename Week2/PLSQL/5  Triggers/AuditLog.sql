-- Create the AuditLog table
CREATE TABLE AuditLog (
    AuditID NUMBER PRIMARY KEY,
    TransactionID NUMBER,
    AccountID NUMBER,
    TransactionDate DATE,
    Amount NUMBER,
    TransactionType VARCHAR2(10),
    LogDate DATE
);

-- Create a sequence for generating unique AuditIDs
CREATE SEQUENCE AuditLog_SEQ
START WITH 1
INCREMENT BY 1
NOCACHE
NOCYCLE;

-- Create the LogTransaction trigger
CREATE OR REPLACE TRIGGER LogTransaction
AFTER INSERT ON Transactions
FOR EACH ROW
BEGIN
    INSERT INTO AuditLog (
        AuditID,
        TransactionID,
        AccountID,
        TransactionDate,
        Amount,
        TransactionType,
        LogDate
    ) VALUES (
        AuditLog_SEQ.NEXTVAL,  -- Get the next value from the sequence
        :NEW.TransactionID,
        :NEW.AccountID,
        :NEW.TransactionDate,
        :NEW.Amount,
        :NEW.TransactionType,
        SYSDATE  -- Current date and time
    );
END LogTransaction;
/
