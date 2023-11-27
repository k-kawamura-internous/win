package jp.co.internous.framepj.model.session;

import java.io.Serializable;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

/**
 * ログインセッション
 * @author インターノウス
 *
 */
@Component
@Scope(value="session", proxyMode=ScopedProxyMode.TARGET_CLASS)
public class LoginSession implements Serializable {
	private static final long serialVersionUID = -4505629762363906244L;

	private int userId;
	private int tmpUserId;
	private String userName;
	private String password;
	private boolean logined;
	
	/*
	 * 以下にGetter / Setter メソッドを作成
	 */

	
}
