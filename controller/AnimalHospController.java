package org.medipaw.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//import org.zerock.controller.BoardController;
//import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.medipaw.domain.AnimalHospVO;
import org.medipaw.domain.Criteria;
import org.medipaw.domain.PageDTO;
import org.medipaw.service.AnimalHospService;

@Log4j
@AllArgsConstructor
@Controller
@RequestMapping("/animalhosp/*")
public class AnimalHospController {
	private AnimalHospService animalHospService;

	@GetMapping("test")
	public String animalHosp() {
		System.out.println("test 작동 확인");
	    return "animalhosp";
	}

	@GetMapping("list")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> list(Criteria cri) {
	    List<AnimalHospVO> hospitalList = animalHospService.selectAllPaging(cri);
	    int totalCount = animalHospService.totalCount(cri);
	    PageDTO pageDTO = new PageDTO(cri, totalCount);
	    Map<String, Object> response = new HashMap<>();
	    response.put("hospitals", hospitalList);
	    response.put("pageMaker", pageDTO); // Add this line  
	    return new ResponseEntity<>(response, HttpStatus.OK);
	}
	@GetMapping("view")//상세조회
	public void view(@RequestParam("ano") int ano, Model model,
				     @ModelAttribute("cri") Criteria cri) {
		model.addAttribute("avo", animalHospService.select(ano));
	}

	@GetMapping("register")
	@PreAuthorize("isAuthenticated()")
	public String register(AnimalHospVO avo, RedirectAttributes rttr) { 
		if(animalHospService.register(avo)) {
			rttr.addFlashAttribute("result", avo.getAnimalhosp_no());
		return "redirect:/animalhosp/list";
		}
		return null;	
	}
   
   @PostMapping(value = "modify")//수정
   public String modify(AnimalHospVO avo, RedirectAttributes rttr,
                        @ModelAttribute ("cri") Criteria cri){
     if(animalHospService.modify(avo)){
        rttr.addFlashAttribute("result", "success");
     }
     return "redirect:/animalhops/list";
   }

  @PostMapping(value = "remove")//삭제
  public String remove(int ano, RedirectAttributes rttr,
                       @ModelAttribute ("cri") Criteria cri){
    if(animalHospService.remove(ano)){
       rttr.addFlashAttribute("result", "success");
    }
    return "redirect:/animalhops/list";
  }
  
  @PostMapping(value = "selectByAddr") // 주소창 검색 조회
  public void selectByAddr(Model model, Criteria cri, @RequestParam String addr) {
      List<AnimalHospVO> searchResult = animalHospService.selectByAddr(cri, addr);
      int totalCount = searchResult.size();
      
      model.addAttribute("searchaddr", searchResult);
      model.addAttribute("pageDTO", new PageDTO(cri, totalCount));
  }
  
  @PostMapping(value = "selectByMap") // 지도상 검색 조회
  public void selectByMap(Model model, Criteria cri,
                          @RequestParam double aLatitude,
                          @RequestParam double aHardness) {
      List<AnimalHospVO> searchResult = animalHospService.selectByMap(cri, aLatitude, aHardness);
      int totalCount = searchResult.size();
      
      model.addAttribute("searchmap", searchResult);
      model.addAttribute("pageDTO", new PageDTO(cri, totalCount));
  }
}
