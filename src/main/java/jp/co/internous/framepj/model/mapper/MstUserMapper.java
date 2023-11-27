package jp.co.internous.framepj.model.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import jp.co.internous.framepj.model.domain.MstUser;

/**
 * mst_userにアクセスするDAO
 * @author インターノウス
 *
 */
@Mapper
public interface MstUserMapper {
	/**
	 * ユーザー情報を登録する
	 * @param user ユーザー情報
	 * @return 登録件数
	 */
	@Insert("XXXX")
	@Options(useGeneratedKeys=true, keyProperty="id")
	int insert(MstUser user);
	
	/**
	 * ユーザー名とパスワードを条件にユーザー情報を取得する
	 * @param userName ユーザー名
	 * @param password パスワード
	 * @return ユーザー情報
	 */
	@Select("XXXX")
	MstUser findByUserNameAndPassword(
			@Param("userName") String userName,
			@Param("password") String password);
	
	/**
	 * ユーザ名を条件に件数を取得する
	 * @param userName ユーザー名
	 * @return 件数
	 */
	@Select("XXXX")
	int findCountByUserName(String userName);
	
	/**
	 * ユーザー名を条件にパスワードを更新する
	 * @param userName ユーザー名
	 * @param password パスワード
	 * @return 更新件数
	 */
	@Update("XXXX")
	int updatePassword(
			@Param("userName") String userName,
			@Param("password") String password);

}
