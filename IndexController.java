package jp.co.internous.perseus.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.perseus.model.mapper.MstCategoryMapper;
import jp.co.internous.perseus.model.mapper.MstProductMapper;
import jp.co.internous.perseus.model.session.LoginSession;
import jp.co.internous.perseus.model.domain.MstCategory;
import jp.co.internous.perseus.model.domain.MstProduct;
import jp.co.internous.perseus.model.form.SearchForm;

@Controller
@RequestMapping("/perseus")
public class IndexController {
	@Autowired
	private MstCategoryMapper categoryMapper;

	@Autowired
	private MstProductMapper productMapper;
	
	@Autowired
	private LoginSession loginSession;
	
	@RequestMapping("/")
	public String index(Model m) {
		
		if (!loginSession.getLogined() && loginSession.getTmpUserId() == 0) {
			int tmpUserId = (int)(Math.random() * 1000000000 * -1);
			//仮ユーザー IDが9桁になるまで10倍する
			while (tmpUserId > -100000000) {
				tmpUserId *= 10;
			}
			loginSession.setTmpUserId(tmpUserId);
		}
		//カテゴリ取得
		List<MstCategory> categories = categoryMapper.find();	
		//商品情報取得
		List<MstProduct> products = productMapper.find();
		
		m.addAttribute("categories", categories);
		m.addAttribute("selected", 0);
		m.addAttribute("products", products);
		m.addAttribute("loginSession",loginSession);
		return "index";
	}
	
	@RequestMapping("/searchItem")
	public String index(SearchForm f, Model m) {
		List<MstProduct> products = null;
		//全角の空白を半角にする。 //2個以上の半角スペースを1つにする。 //先頭と末尾の空白を削除する。
		String keywords = f.getKeywords().replaceAll("　"," ").replaceAll(" {2,}", " ").trim();
		
		if (f.getCategory() == 0) {
			
			products = productMapper.findByProductName(keywords.split(" "));
		} else {
			products = productMapper.findByCategoryAndProductName(f.getCategory(), keywords.split(" "));
			
		}

		List<MstCategory> categories = categoryMapper.find();
		m.addAttribute("keywords", keywords);
		m.addAttribute("selected", f.getCategory()); 
		m.addAttribute("categories", categories); 
		m.addAttribute("products", products);
		m.addAttribute("loginSession",loginSession);
		
		return "index";
		
	}
}