
package entities;

import DAO.OngDAO;
import java.util.List;
import javax.swing.table.AbstractTableModel;
//import javax.swing.table.DefaultTableModel;

public class OngTableModel extends AbstractTableModel {
    
    private List<Ong> ongs;
    private String[] colunas = {"ID", "NOME", "EMAIL", "Estado", "UF", "Telefone", "Causa", "CNPJ", "Site"};
    
    //Refência a classe para busacar as ongs
    public OngTableModel() throws Exception {
        OngDAO dao = new OngDAO();
        this.ongs = dao.buscarOngs();  
    }

    @Override
    public int getRowCount() {
        return ongs.size();
    }
    

    @Override
    public int getColumnCount() {
        return 9;
    }
    
    //Criação das colunas das ongs
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        switch (columnIndex) {
            case 0:
                return this.ongs.get(rowIndex).getId();
            case 1:
                return this.ongs.get(rowIndex).getNome();
            case 2:
                return this.ongs.get(rowIndex).getEmail();  
            case 3:
                return this.ongs.get(rowIndex).getEstado();
            case 4:
                return this.ongs.get(rowIndex).getUf();
            case 5:
                return this.ongs.get(rowIndex).getTelefone();     
            case 6:
                return this.ongs.get(rowIndex).getCausa();
            case 7:
                return this.ongs.get(rowIndex).getCnpj();
            case 8:
                return this.ongs.get(rowIndex).getSite();             
            default:
                return null;
        }
    }
   
    @Override
    public String getColumnName(int column) {
        return this.colunas[column];
    }
    
    
    
    

    


    
    
}
