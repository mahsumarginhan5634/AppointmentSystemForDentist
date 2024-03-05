package HelperClasses;

import javax.swing.table.DefaultTableModel;

public class NonEditableDefaultTableModel extends DefaultTableModel 
{
        /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public NonEditableDefaultTableModel() 
    {
        
    }

    // Override the isCellEditable method to make all cells non-editable
    @Override
    public boolean isCellEditable(int row, int column) 
    {
        return false; // Return false to make all cells non-editable
    }
    }