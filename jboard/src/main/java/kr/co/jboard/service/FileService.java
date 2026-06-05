package kr.co.jboard.service;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.Part;
import kr.co.jboard.dao.FileDAO;
import kr.co.jboard.dto.FileDTO;

public enum FileService {
	// 열거 상수 객체(싱글톤)
	INSTANCE;
	
	// DAO 가져오기
	private FileDAO dao = FileDAO.getInstance();
	
	// 파일 업로드
	public List<FileDTO> upload(HttpServletRequest request) {
		// 반환용 파일 리스트 생성
		List<FileDTO> dtoList = new ArrayList<>();
		
		// 파일 업로드 디렉토리 생성 구하기
		ServletContext ctx = request.getServletContext();
		String uploadPath = ctx.getRealPath("/upload");
		System.out.println(uploadPath);
		
		// 해당 디렉토리가 존재하지 않으면 신규생성
		File uploadDir = new File(uploadPath);
		if(!uploadDir.exists()) {
			uploadDir.mkdir();
		}
		
		try {
			// 첨부파일 객체 구하기
			Collection<Part> parts = request.getParts(); // part : 첨부파일 객체
			
			for(Part part:parts) { // 폼태그 입력필드 갯수가 5개이므로 5회 반복
				// 원본 파일명 구하기
				String ofName = part.getSubmittedFileName();
			
				System.out.println(ofName);
				
				if(ofName != null && !ofName.isEmpty()) {
					// 저장 파일명 구하기
					int idx = ofName.lastIndexOf(".");
					String ext = ofName.substring(idx);
					String sfName = UUID.randomUUID().toString() + ext;
					
					System.out.println(sfName);
					
					// 파일 저장
					part.write(uploadPath + File.separator + sfName);
					
					// FileDTO 생성 및 리스트 저장
					FileDTO fileDTO = new FileDTO();
					fileDTO.setOfname(ofName);
					fileDTO.setSfname(sfName);
					
					dtoList.add(fileDTO);
				}
				
			}
		} catch (Exception e) {
			
		}
		return dtoList;
	}

	// 파일 다운로드
	public void download() {
		
	}
	
	// 기본 서비스 메서드
	public void register(FileDTO dto) {
		dao.insert(dto);
	}

	public FileDTO findById(String fno) {
		return dao.select(fno);
	}

	public List<FileDTO> findAll() {
		return dao.selectAll();
	}

	public void modify(FileDTO dto) {
		dao.update(dto);
	}

	public void remove(String fno) {
		dao.delete(fno);
	}
	
}
