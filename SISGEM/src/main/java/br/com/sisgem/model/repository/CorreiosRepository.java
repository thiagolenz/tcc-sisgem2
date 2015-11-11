package br.com.sisgem.model.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.stereotype.Repository;

import br.com.sisgem.model.CorreiosBean;
import br.com.sisgem.relatorios.jdbc.ConnectionFactory;

@Repository
public class CorreiosRepository {
	String sql = " select "+
			" lo.NO_LOGRADOURO_CEP as cep,"+
			" lo.DS_LOGRADOURO_NOME as nomerua, "+
			" ba.ds_bairro_nome as nomeBairro, "+
			" ci.ds_cidade_nome as nomeCidade,"+
			" u.ds_uf_sigla as siglaEstado"+
			" from logradouros lo "+
			" INNER JOIN bairros ba on ba.cd_bairro = lo.cd_bairro "+
			" INNER JOIN cidades ci on ba.cd_cidade = ci.cd_cidade "+
			" inner join uf u on ci.cd_uf = u.cd_uf "+

			" where lo.NO_LOGRADOURO_CEP = ?";
	
	public CorreiosBean findByCep (String cep) {
		Connection connection  = null;
		PreparedStatement stat = null;
		try {
			connection = ConnectionFactory.getSakilaConnection();
			stat = connection.prepareStatement(sql);
			stat.setString(1, cep);
			ResultSet set = stat.executeQuery();
			if (set.next()) {
				CorreiosBean bean = new CorreiosBean();
				bean.setCep(set.getString("cep"));
				bean.setNomeRua(set.getString("nomerua"));
				bean.setCidade(set.getString("nomeCidade"));
				bean.setEstado(set.getString("siglaEstado"));
				bean.setBairro(set.getString("nomeBairro"));
				return bean;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				if (stat != null)
					stat.close();
				if (connection != null)
					connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		return null;
	}
}
