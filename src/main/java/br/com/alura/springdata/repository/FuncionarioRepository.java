package br.com.alura.springdata.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import br.com.alura.springdata.orm.Funcionario;
import br.com.alura.springdata.orm.FuncionarioProjecao;

/**
 * 
 * @parametro Derived query, com comandos java
 * @parametro JPQL - utilizando o objeto para realizar a busca
 * @parametro Native Query - utiliza o atributo para realizar a busca
 * 
 * @parametro {@link CrudRepository} a bala de prata do spring data, resolve a maioria dos problemas
 * @parametro {@link PagingAndSortingRepository} para realizar algo mais personalizado
 *
 */

@Repository
public interface FuncionarioRepository extends PagingAndSortingRepository<Funcionario, Integer>, 
		JpaSpecificationExecutor<Funcionario> {
	List<Funcionario> findByNome(String nome);
	
	@Query("SELECT f FROM Funcionario f WHERE f.nome = :nome"
			+ " AND f.salario >= :salario "
			+ "AND f.dataContratacao = :data")
	List<Funcionario>findNomeSalarioMaiorDataContratacao(String nome, Double salario, LocalDate data);
	
	@Query(value = " SELECT * FROM Funcionario f WHERE f.datacontratacao >= :data ", 
			nativeQuery = true)
	List<Funcionario> findDataContratacaoMaior(LocalDate data);
	
	@Query(value = " SELECT f.id, f.nome, f.salario FROM Funcionario f ", nativeQuery = true)
	List<FuncionarioProjecao> findFuncionarioSalario();
}
