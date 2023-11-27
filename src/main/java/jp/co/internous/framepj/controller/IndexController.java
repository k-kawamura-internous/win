package jp.co.internous.framepj.controller;

import java.util.List;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import jp.co.internous.framepj.model.domain.MstCategory;
import jp.co.internous.framepj.model.domain.MstProduct;
import jp.co.internous.framepj.model.mapper.MstCategoryMapper;
import jp.co.internous.framepj.model.mapper.MstProductMapper;
import jp.co.internous.framepj.model.session.LoginSession;

/**
 * 商品検索に関する処理を行うコントローラー
 * @author インターノウス
 */


@Controller
@RequestMapping("/frameweb")
public class IndexController {

	/*
	 * フィールド定義
	 */
	
	@Autowired
	private MstCategoryMapper categoryMapper;
	
	@Autowired
	private MstProductMapper productMapper;
	
	@Autowired
	private LoginSession loginSession;

	/**
	 * トップページを初期表示する。
	 * @param m 画面表示用オブジェクト
	 * @return トップページ
	 */
	@RequestMapping("/")
	public String index(Model m) {
		if (!loginSession.isLogined() && loginSession.getTmpUserId() == 0) {
			int tmpUserId = new Random().nextInt(1_000_000_000);
			tmpUserId *= -1;
			loginSession.setTmpUserId(tmpUserId);
		}
	
		List<MstCategory> categories = categoryMapper.find();	
		List<MstProduct> products = productMapper.find();
		
		m.addAttribute("categories", categories);
		m.addAttribute("selected", 0);
		m.addAttribute("products", products);
		m.addAttribute("loginSession", loginSession);
		
		return "index";
	}
}