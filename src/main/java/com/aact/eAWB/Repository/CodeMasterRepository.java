package com.aact.eAWB.Repository;

import java.math.BigInteger;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.aact.eAWB.Dto.CodeDto;
import com.aact.eAWB.Entity.TcmCodeMaster;

@Repository
public interface CodeMasterRepository extends JpaRepository<TcmCodeMaster, BigInteger> {

	@Query("SELECT new com.aact.eAWB.Dto.CodeDto(c,o) "
			+ "FROM TcmCodeMaster c "
			+ "LEFT JOIN TcmObjectLanguage o "
			+ "ON o.id.objectSid = c.codeSid "
			+ "AND o.id.languageCode = 'ENG' "
			+ "WHERE c.classCode = :classCode "
			+ "AND c.codeCode = :codeCode")
	List<CodeDto> getCodeDto(@Param("classCode")String classCode, @Param("codeCode")String codeCode);
	
	
}
