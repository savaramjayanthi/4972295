CREATE OR REPLACE PROCEDURE UpdateSalary (
    p_employee_id IN NUMBER,
    p_percentage IN NUMBER
) AS
    v_current_salary NUMBER;
BEGIN
    -- Check if the employee exists and get their current salary
    SELECT Salary INTO v_current_salary FROM Employees WHERE EmployeeID = p_employee_id;

    -- Update the salary
    UPDATE Employees
    SET Salary = Salary * (1 + p_percentage / 100), LastModified = SYSDATE
    WHERE EmployeeID = p_employee_id;

    COMMIT;

EXCEPTION
    WHEN NO_DATA_FOUND THEN
        DBMS_OUTPUT.PUT_LINE('Error: Employee with ID ' || p_employee_id || ' does not exist.');
    WHEN OTHERS THEN
        DBMS_OUTPUT.PUT_LINE('Error: ' || SQLERRM);
END UpdateSalary;
/
