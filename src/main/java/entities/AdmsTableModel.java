
package entities;

import DAO.AdmDAO;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class AdmsTableModel extends AbstractTableModel {
    
    private List<Administradores> adms;
    private String [] colunas = {"ID", "Login", "Senha", "Nome"}; 
    
    
    
    public AdmsTableModel() throws Exception {
        AdmDAO dao = new AdmDAO();
        this.adms = dao.buscarAdms();  
    }

    @Override
    public int getRowCount() {
        return adms.size();
    }

    @Override
    public int getColumnCount() {
        return 4;
    }
    
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.adms.get(rowIndex).getId();
            case 1:
                return this.adms.get(rowIndex).getLogin();
            case 2:
                return this.adms.get(rowIndex).getNome();  
            case 3:
                return this.adms.get(rowIndex).getSenha();          
            default:
                return null;
        }
    }
    
    @Override
    public String getColumnName(int column) {
        return this.colunas[column];
    }
    
    
    public void addAdm(Administradores adm) {
        // Adiciona o registro.
        adms.add(adm);
        int ultimoIndice = getRowCount() - 1;
        fireTableRowsInserted(ultimoIndice, ultimoIndice);
    }
    
    
    

}
