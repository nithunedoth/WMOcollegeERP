package com.mes.controller;

import java.util.List;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mes.model.Constant;
import com.mes.model.vo.BatchesVO;
import com.mes.model.vo.ClassTimingsVO;
import com.mes.model.vo.CourseWrapperVO;
import com.mes.model.vo.CoursesVO;
import com.mes.model.vo.DepartmentWrapperVO;
import com.mes.model.vo.DepartmentsVO;
import com.mes.model.vo.OutoutVO;
import com.mes.model.vo.PapersVO;
import com.mes.model.vo.SampleVO;
import com.mes.model.vo.SchemesVO;
import com.mes.model.vo.TeachersVO;
import com.mes.model.vo.TermDatesVO;
import com.mes.model.vo.TermStructuresVO;
import com.mes.model.vo.TermsVO;
import com.mes.service.MesErpService;
@RestController
@RequestMapping("/data")


public class MesERPController {
	
	@Autowired
	public MesErpService meserpservice;

	@RequestMapping("/deploys")
	public @ResponseBody String deploys(){
		return "successfully deployed application"+Constant.studyMode.Theory;
	}
	
	@RequestMapping("/saveSamples")
	public @ResponseBody String saveSamples(){
		SampleVO sampleVO=new SampleVO(1,"sadik");
		String cg=meserpservice.saveSample(sampleVO);
		return "success";
	}
	
	@RequestMapping(value="/getSamples")
	public @ResponseBody List<SampleVO> getSamples(){
		List<SampleVO> sampleVOs=meserpservice.getSample();
		return sampleVOs;
	}
	
	@RequestMapping(value="/departments",method=RequestMethod.GET)
	public @ResponseBody OutoutVO listDepartments(){
		System.out.println("in");
		OutoutVO outoutVO=meserpservice.listdepartment();
		/*List<DepartmentsVO> departmentsVOs=departmentWrapperVO.getData();
		OutoutVO outoutVO=new OutoutVO();
		outoutVO.setData(departmentsVOs);
		outoutVO.setCount(departmentWrapperVO.getCount());
		//outoutVO.setSuccess(departmentWrapperVO.getSuccess());
		outoutVO.setKind(departmentWrapperVO.getKind());*/
		return outoutVO;
	}
	
	@RequestMapping(value="/departments/{deptId}",method=RequestMethod.GET)
	public @ResponseBody OutoutVO departments(@PathVariable(value="deptId") int id){
		OutoutVO outoutVO=meserpservice.getdepartment(id);
		return outoutVO;
	}
	
	@RequestMapping(value="/departments",method=RequestMethod.POST)
	public @ResponseBody OutoutVO addDepartment(@RequestBody DepartmentsVO departmentsVO){
		OutoutVO outoutVO=meserpservice.addDepartment(departmentsVO);
		/*System.out.println(s);
		DepartmentWrapperVO departmentWrapperVO=null;
		if(s.equalsIgnoreCase("success")){
			System.out.println("to");
			departmentWrapperVO=meserpservice.listdepartment();
		}*/
		return outoutVO;
	}
	
	@RequestMapping(value="/departments/{deptId}",method=RequestMethod.PUT)
	public @ResponseBody OutoutVO editDepartment(@PathVariable(value="deptId") int id,@RequestBody DepartmentsVO departmentsVO){
		OutoutVO outoutVO=meserpservice.editDepartment(id,departmentsVO);
		/*OutoutVO outoutVO=null;
		if(s.equalsIgnoreCase("success")){
			outoutVO=meserpservice.listdepartment();
		}*/
		return outoutVO;
	}
	
	@RequestMapping(value="/departments/{deptId}",method=RequestMethod.DELETE)
	public @ResponseBody OutoutVO deleteDepartments(@PathVariable(value="deptId") int id){
	    System.out.println("out");
	    System.out.println(id);
	    OutoutVO outoutVO=meserpservice.deleteDepartment(id);
		/*System.out.println(s);
		OutoutVO outoutVO=null;
		if(s.equalsIgnoreCase("success")){
			outoutVO=meserpservice.listdepartment();
		}*/
		return outoutVO;
	}
	
	@RequestMapping(value="/departments/{deptId}/courses",method=RequestMethod.GET)
	public @ResponseBody OutoutVO listCourses(@PathVariable(value="deptId") int id){
		OutoutVO outoutVO=meserpservice.listCourse(id);
		return outoutVO;
		}
	
	@RequestMapping(value="/courses/{id}",method=RequestMethod.GET)
	public @ResponseBody OutoutVO getCourse(@PathVariable(value="id") int id){
		OutoutVO outoutVO=meserpservice.getCourse(id);
		return outoutVO;
	}
	
	@RequestMapping(value="/departments/{deptId}/courses",method=RequestMethod.POST)
	public @ResponseBody OutoutVO addCourses(@PathVariable(value="deptId") int deptId,@RequestBody CoursesVO coursesVO){
		System.out.println(deptId);
		OutoutVO outoutVO=meserpservice.addCourse(deptId,coursesVO);
		return outoutVO;
		}
	
	@RequestMapping(value="/courses/{id}",method=RequestMethod.PUT)
	public @ResponseBody OutoutVO editCourses(@PathVariable(value="id") int id,@RequestBody CoursesVO coursesVO){
		System.out.println(id);
		OutoutVO outoutVO=meserpservice.editCourse(id,coursesVO);
		/*OutoutVO outoutVO=null;
		if(s.equalsIgnoreCase("success")){
			outoutVO=meserpservice.listCourse(id);
		}*/
		return outoutVO;
	}
	
	@RequestMapping(value="/courses/{id}",method=RequestMethod.DELETE)
	public @ResponseBody OutoutVO deleteCourses(@PathVariable(value="id") int id){
		OutoutVO outoutVO=meserpservice.deleteCourse(id);
//		OutoutVO outoutVO=null;
//		if(s.equalsIgnoreCase("success")){
//			outoutVO=meserpservice.listCourse(id);
//		}
		return outoutVO;
	}
	
	  @RequestMapping(value="/courses/{id}/schemes",method=RequestMethod.GET)	
	    public @ResponseBody OutoutVO getCourseSchemes(@PathVariable(value="id") int id){
	    	System.out.println("coursesschemes");
	    	System.out.println(id);
	    	OutoutVO outoutVO=meserpservice.getCourseSchemes(id);
			return outoutVO;
			}
	
    @RequestMapping(value="/courses/{id}/batches",method=RequestMethod.GET)	
    public @ResponseBody OutoutVO listBatches(@PathVariable(value="id") int id){
    	System.out.println("listing batches");
    	OutoutVO outoutVO=meserpservice.listBatch(id);
		return outoutVO;
		}
    
    @RequestMapping(value="/courses/{id}/schemes/{scheme_id}/papers",method=RequestMethod.GET)	
    public @ResponseBody OutoutVO listSchemePaper(@PathVariable(value="id") int id,@PathVariable(value="scheme_id") int schemeId,@RequestParam int term_id){
    	System.out.println("nithun");
    	System.out.println("course id"+id);
    	System.out.println("scheme id"+schemeId);
    	System.out.println("term id"+term_id);
    	OutoutVO outoutVO=meserpservice.listSchemePaper(id,schemeId,term_id);
		return outoutVO;
		}
  
    
    @RequestMapping(value="/batches/{id}",method=RequestMethod.GET)
	public @ResponseBody OutoutVO getBatch(@PathVariable(value="id") int id){
    	OutoutVO outoutVO=meserpservice.getBatch(id);
		return outoutVO;
	}
    
    @RequestMapping(value="/courses/{id}/batches",method=RequestMethod.POST)
   	public @ResponseBody OutoutVO saveBatch(@PathVariable(value="id") int id,@RequestBody BatchesVO batchesVO){
    	System.out.println("in"+id);
    	OutoutVO outoutVO=meserpservice.saveBatch(id,batchesVO);
   		return outoutVO;
   	}
    
    @RequestMapping(value="/batches/{id}",method=RequestMethod.PUT)
	public @ResponseBody OutoutVO editBatch(@PathVariable(value="id") int id,@RequestBody BatchesVO batchesVO){
    	OutoutVO outoutVO=meserpservice.editBatch(id,batchesVO);
		return outoutVO;
	}
    
    @RequestMapping(value="/batches/{id}",method=RequestMethod.DELETE)
   	public @ResponseBody OutoutVO deleteBatch(@PathVariable(value="id") int id){
    	OutoutVO outoutVO=meserpservice.deleteBatch(id);
		return outoutVO;
   	}
    
    @RequestMapping(value="/class_timings",method=RequestMethod.GET)
	public @ResponseBody OutoutVO listClassTiming(){
    	OutoutVO outoutVO=meserpservice.listClassTiming();
		return outoutVO;
	}
    
    @RequestMapping(value="/class_timings/{id}",method=RequestMethod.GET)
	public @ResponseBody OutoutVO getClassTimings(@PathVariable(value="id") int id){
    	OutoutVO outoutVO=meserpservice.getClassTiming(id);
		return outoutVO;
	}
    
    @RequestMapping(value="/class_timings",method=RequestMethod.POST)
   	public @ResponseBody OutoutVO addClassTimings(@RequestBody ClassTimingsVO classTimingsVO){
    	OutoutVO outoutVO=meserpservice.addClassTimings(classTimingsVO);
    	return outoutVO;
   	}
    
    @RequestMapping(value="/class_timings/{id}",method=RequestMethod.PUT)
   	public @ResponseBody OutoutVO editClassTiming(@PathVariable(value="id") int id,@RequestBody ClassTimingsVO classTimingsVO){
   		String s=meserpservice.editClassTiming(id,classTimingsVO);
   		OutoutVO outoutVO=null;
		if(s.equalsIgnoreCase("success")){
			outoutVO=meserpservice.listdepartment();
		}
		return outoutVO;
   	}
    
    @RequestMapping(value="/class_timings/{id}",method=RequestMethod.DELETE)
   	public @ResponseBody OutoutVO deleteClassTiming(@PathVariable(value="id") int id){
   		String s=meserpservice.deleteClassTiming(id);
   		OutoutVO outoutVO=null;
		if(s.equalsIgnoreCase("success")){
			outoutVO=meserpservice.listdepartment();
		}
		return outoutVO;
   	}
    
    @RequestMapping("/addall")
    public @ResponseBody String addall(){
    	String s=meserpservice.addall();
    	return null;
    }
    
    @RequestMapping(value="/papers",method=RequestMethod.GET)
    public @ResponseBody OutoutVO viewPapers(){
    	OutoutVO outoutVO=meserpservice.viewPaper();
    	return outoutVO;
    }
    
    @RequestMapping(value="/papers/{id}",method=RequestMethod.GET)
    public @ResponseBody OutoutVO listPapers(@PathVariable(value="id") int id){
    	System.out.println("getting paper by id");
    	OutoutVO outoutVO=meserpservice.listPaper(id);
    	return outoutVO;
    }
    
    @RequestMapping(value="/papers",method=RequestMethod.POST)
   	public @ResponseBody OutoutVO addPapers(@RequestBody PapersVO papersVO){
    	System.out.println(papersVO.getCode());
    	System.out.println(papersVO.getPaperType());
    	System.out.println(papersVO.getDepartmentId());
    	System.out.println(papersVO.getCourseId());
    	OutoutVO outoutVO=meserpservice.addPapers(papersVO);
   		return outoutVO;
   	}
    
    @RequestMapping(value="/papers/{id}",method=RequestMethod.PUT)
   	public @ResponseBody OutoutVO editPapers(@PathVariable(value="id") int id,@RequestBody PapersVO papersVO){
    	System.out.println("editing paper by id");
    	OutoutVO outoutVO=meserpservice.editPaper(id,papersVO);
		return outoutVO;
   	}
    
    @RequestMapping(value="/papers/{id}",method=RequestMethod.DELETE)
   	public @ResponseBody OutoutVO deletePapers(@PathVariable(value="id") int id){
    	OutoutVO outoutVO=meserpservice.deletePaper(id);
		return outoutVO;
   	}
    
    @RequestMapping(value="/schemes",method=RequestMethod.GET)
    public @ResponseBody OutoutVO listSchemes(){
    	OutoutVO outoutVO=meserpservice.listScheme();
    	return outoutVO;
    }
    
    @RequestMapping(value="/schemes/{id}",method=RequestMethod.GET)
	public @ResponseBody OutoutVO getScheme(@PathVariable(value="id") int id){
    	OutoutVO outoutVO=meserpservice.getScheme(id);
		return outoutVO;
	}
    
    @RequestMapping(value="/schemes",method=RequestMethod.POST)
   	public @ResponseBody OutoutVO addScheme(@RequestBody SchemesVO schemesVO){
        System.out.println("IN");
    	OutoutVO outoutVO=meserpservice.addScheme(schemesVO);
   		return outoutVO;
   	}
    
    @RequestMapping(value="/schemes/{id}",method=RequestMethod.PUT)
   	public @ResponseBody OutoutVO editScheme(@PathVariable(value="id") int id,@RequestBody SchemesVO schemesVO){
    	OutoutVO outoutVO=meserpservice.editScheme(id,schemesVO);
       
		/*if(s.equalsIgnoreCase("success")){
			outoutVO=meserpservice.listScheme();
		}*/
		return outoutVO;
   	}
    
    @RequestMapping(value="/schemes/{id}",method=RequestMethod.DELETE)
   	public @ResponseBody OutoutVO deleteScheme(@PathVariable(value="id") int id){
    	OutoutVO outoutVO=meserpservice.deleteScheme(id);
		return outoutVO;
   	}
    
    @RequestMapping(value="/schemes/{id}/courses",method=RequestMethod.GET)
    public @ResponseBody OutoutVO getSchemeCourse(@PathVariable(value="id") int id){
    	OutoutVO outoutVO=meserpservice.getSchemeCourse(id);
		return outoutVO;
   	}
    @RequestMapping(value="/term_structures",method=RequestMethod.GET)
    public @ResponseBody OutoutVO listTermStructures(){
    	OutoutVO outoutVO=meserpservice.listTermStructures();
    	return outoutVO;
    }
    
    @RequestMapping(value="/term_structures/{id}",method=RequestMethod.GET)
    public @ResponseBody OutoutVO getTermStructure(@PathVariable(value="id") int id){
    	OutoutVO outoutVO=meserpservice.getTermStructure(id);
    	return outoutVO;
    }
    
    @RequestMapping(value="/term_structures",method=RequestMethod.POST)
    public @ResponseBody OutoutVO getTermStructure(@RequestBody TermStructuresVO termStructuresVO){
    	OutoutVO outoutVO=meserpservice.addTermStructure(termStructuresVO);
    	return outoutVO;
    }
    
    @RequestMapping(value="/term_structures/{id}",method=RequestMethod.PUT)
    public @ResponseBody OutoutVO editTermStructure(@PathVariable(value="id") int id,@RequestBody TermStructuresVO termStructuresVO){
    	OutoutVO outoutVO=meserpservice.editTermStructure(id,termStructuresVO);
		return outoutVO;
    }
    
    @RequestMapping(value="/term_structures/{id}",method=RequestMethod.DELETE)
    public @ResponseBody OutoutVO deleteTermStructure(@PathVariable(value="id") int id){
    	OutoutVO outoutVO=meserpservice.deleteTermStructure(id);
		return outoutVO;
    }
    
    @RequestMapping(value="/term_structures/{id}/terms",method=RequestMethod.GET)
    public @ResponseBody OutoutVO listTerms(@PathVariable(value="id") int id){
    	System.out.println("term_structures id is"+id);
    	OutoutVO outoutVO=meserpservice.listTerm(id);
    	return outoutVO;
    }
    
    @RequestMapping(value="/terms/{id}",method=RequestMethod.GET)
    public @ResponseBody OutoutVO getTerms(@PathVariable(value="id") int id){
    	OutoutVO outoutVO=meserpservice.getTerm(id);
    	return outoutVO;
    }
    
    @RequestMapping(value="/term_structures/{id}/terms",method=RequestMethod.POST)
    public @ResponseBody OutoutVO addTerms(@PathVariable(value="id") int id,@RequestBody TermsVO termsVO){
    	System.out.println(termsVO.getCode());
    	System.out.println(termsVO.getName());
    	System.out.println(termsVO.getPosition());
    	OutoutVO outoutVO=meserpservice.addTerm(id,termsVO);
    	return outoutVO;
    }
    
    @RequestMapping(value="/terms/{id}",method=RequestMethod.PUT)
    public @ResponseBody OutoutVO editTerms(@PathVariable(value="id") int id,@RequestBody TermsVO termsVO){
    	OutoutVO outoutVO=meserpservice.editTerm(id,termsVO);
		return outoutVO;
    }
    
    @RequestMapping(value="/terms/{id}",method=RequestMethod.DELETE)
    public @ResponseBody OutoutVO deleteTerms(@PathVariable(value="id") int id){
    	OutoutVO outoutVO=meserpservice.deleteTerm(id);
		return outoutVO;
    }
    
    @RequestMapping(value="/batches/{batch_id}/term_dates",method=RequestMethod.GET)
    public @ResponseBody OutoutVO listTermDates(@PathVariable(value="batch_id") int id){
    	OutoutVO outoutVO=meserpservice.listTermDate(id);
    	return outoutVO;
    }
    
    @RequestMapping(value="/term_dates/{id}",method=RequestMethod.GET)
    public @ResponseBody OutoutVO getTermDates(@PathVariable(value="id") int id){
    	OutoutVO outoutVO=meserpservice.getTermDate(id);
    	return outoutVO;
    }
    
    @RequestMapping(value="/batches/{batch_id}/term_dates",method=RequestMethod.POST)
    public @ResponseBody OutoutVO addTermDates(@PathVariable(value="batch_id") int id,@RequestBody TermDatesVO termDatesVO){
    	OutoutVO outoutVO=meserpservice.addTermDate(id,termDatesVO);
    	return outoutVO;
    }
    
    @RequestMapping(value="/term_dates/{id}",method=RequestMethod.PUT)
    public @ResponseBody OutoutVO editTermDates(@PathVariable(value="id") int id,@RequestBody TermDatesVO termDatesVO){
    	String s=meserpservice.editTermDate(id,termDatesVO);
    	OutoutVO outoutVO=null;
		if(s.equalsIgnoreCase("success")){
			outoutVO=meserpservice.listTermDate(id);
		}
		return outoutVO;
    }
    
    @RequestMapping(value="/class_timings/{class_timing_id}/periods",method=RequestMethod.GET)
   	public @ResponseBody OutoutVO getPeriods(@PathVariable(value="class_timing_id") int id){
       	OutoutVO outoutVO=meserpservice.getPeriod(id);
   		return outoutVO;
   	}
    
    @RequestMapping(value="/teachers",method=RequestMethod.GET)
   	public @ResponseBody OutoutVO listTeacher(){
        System.out.println("in");
    	OutoutVO outoutVO=meserpservice.listTeacher();
   		return outoutVO;
   	}

    
    
    @RequestMapping(value="/teachers/{id}",method=RequestMethod.GET)
   	public @ResponseBody OutoutVO getTeacher(@PathVariable(value="id") int id){
        System.out.println("in");
    	//OutoutVO outoutVO=meserpservice.getTeacher(teachersVO);
   		return null;
   	}
    
    @RequestMapping(value="/teachers",method=RequestMethod.POST)
   	public @ResponseBody OutoutVO saveTeacher(@RequestBody TeachersVO teachersVO){
        System.out.println("teachers in");
    	OutoutVO outoutVO=meserpservice.saveTeacher(teachersVO);
   		return outoutVO;
   	}
    
    @RequestMapping(value="/teachers/{id}",method=RequestMethod.PUT)
   	public @ResponseBody OutoutVO editTeacher(@PathVariable(value="id") int id,@RequestBody TeachersVO teachersVO){
        System.out.println("editing teachers");
        System.out.println("teacher id"+id);
    	OutoutVO outoutVO=meserpservice.editTeacher(id,teachersVO);
    	return outoutVO;
   	}
    
    @RequestMapping(value="/teachers/{id}",method=RequestMethod.DELETE)
   	public @ResponseBody OutoutVO deleteTeacher(@PathVariable(value="id") int id){
        System.out.println("deleting teachers");
        System.out.println("teacher id"+id);
    	OutoutVO outoutVO=meserpservice.deleteTeacher(id);
    	return outoutVO;
   	}
    
    @RequestMapping(value="/teachers/{department_id}/teachers",method=RequestMethod.GET)
   	public @ResponseBody OutoutVO viewDepartmentTeacher(@RequestParam int department_id){
        System.out.println("view common department teachers");
        System.out.println(department_id);
    	OutoutVO outoutVO=meserpservice.viewDepartmentTeacher(department_id);
    	return outoutVO;
   	}
    
    @RequestMapping(value="/departments/{id}/schemes/{scheme_id}/common_papers",method=RequestMethod.GET)
	public @ResponseBody OutoutVO viewDepartmentSchemePaper(@PathVariable(value="id") int id,@PathVariable(value="scheme_id") int scheme_id){
        System.out.println("view department scheme papers");
        System.out.println(id);
    	OutoutVO outoutVO=meserpservice.viewDepartmentSchemePaper(id,scheme_id);
    	return outoutVO;
   	}

	}
