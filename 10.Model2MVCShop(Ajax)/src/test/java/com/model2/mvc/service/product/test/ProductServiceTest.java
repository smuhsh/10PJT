package com.model2.mvc.service.product.test;

import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.model2.mvc.common.Search;
import com.model2.mvc.service.domain.Product;
import com.model2.mvc.service.product.ProductService;


/*
 *	FileName :  ProductServiceTest.java
 * �� JUnit4 (Test Framework) �� Spring Framework ���� Test( Unit Test)
 * �� Spring �� JUnit 4�� ���� ���� Ŭ������ ���� ������ ��� ���� �׽�Ʈ �ڵ带 �ۼ� �� �� �ִ�.
 * �� @RunWith : Meta-data �� ���� wiring(����,DI) �� ��ü ����ü ����
 * �� @ContextConfiguration : Meta-data location ����
 * �� @Test : �׽�Ʈ ���� �ҽ� ����
 */
@RunWith(SpringJUnit4ClassRunner.class)
//==> Meta-Data �� �پ��ϰ� Wiring ����...
//@ContextConfiguration(locations = { "classpath:config/context-*.xml" })
@ContextConfiguration	(locations = {	"classpath:config/context-common.xml",
																	"classpath:config/context-aspect.xml",
																	"classpath:config/context-mybatis.xml",
																	"classpath:config/context-transaction.xml" })
//@ContextConfiguration(locations = { "classpath:config/context-common.xml" })
public class ProductServiceTest {

	//==>@RunWith,@ContextConfiguration �̿� Wiring, Test �� instance DI
	@Autowired
	@Qualifier("ProductServiceImpl")
	private ProductService productService;

	//@Test // 2022-04-11 shhwang
	public void testAddProduct() throws Exception {
		
		Product product = new Product();
		product.setProdName("will");
		product.setProdDetail("will");
		product.setManuDate("20220411");
		//product.setPrice(Integer.parseInt(("price")));
		product.setPrice(50000);
		product.setFileName("will.gif");
		
		productService.addProduct(product);
		
		//product = productService.getProduct("10000"); //�� int �� �� �޴��� �𸣰��� 2022-04-09 �˾���. ProductServiceImpl �ڷ��� ����.

		//==> console Ȯ��
		//System.out.println(user);
		
		//==> API Ȯ��
		Assert.assertEquals("will", product.getProdName());
		Assert.assertEquals("will", product.getProdDetail());
		Assert.assertEquals("20220411", product.getManuDate());
		Assert.assertEquals(50000, product.getPrice());
		Assert.assertEquals("will.gif", product.getFileName());
	}
	
	@Test // 2022-04-11 shhwang
	public void testGetProduct() throws Exception {
		
		Product product = new Product();
		//==> �ʿ��ϴٸ�...
//		user.setUserId("testUserId");
//		user.setUserName("testUserName");
//		user.setPassword("testPasswd");
//		user.setSsn("1111112222222");
//		user.setPhone("111-2222-3333");
//		user.setAddr("��⵵");
//		user.setEmail("test@test.com");
		
		product = productService.getProduct(10021);//�� int �� �� �޴��� �𸣰��� 2022-04-09 �˾���. ProductServiceImpl �ڷ��� ����.
		
		//==> console Ȯ��
		System.out.println(product);
		
		//==> API Ȯ��		
		Assert.assertEquals(10021, product.getProdNo());
		Assert.assertEquals("pixiv", product.getProdName());
		Assert.assertEquals("pixiv", product.getProdDetail());
		Assert.assertEquals("20220405", product.getManuDate());
		Assert.assertEquals(100000, product.getPrice());
		Assert.assertEquals("girl01.jpg", product.getFileName());
	}
	
	 //@Test // 2022-04-11 shhwang
	 public void testUpdateProduct() throws Exception{
		 
		Product product = productService.getProduct(10026);
		Assert.assertNotNull(product);
		
		Assert.assertEquals("shhwang", product.getProdName());
		Assert.assertEquals("shhwang", product.getProdDetail());
		Assert.assertEquals("20220409", product.getManuDate());
		Assert.assertEquals(50000, product.getPrice());
		Assert.assertEquals("demian.gif", product.getFileName());

		product.setProdName("���̾�");
		product.setProdDetail("���̾�");
		product.setManuDate("20220409");
		product.setPrice(10000);
		product.setFileName("demian.gif");
		
		productService.updateProduct(product);
		
		product = productService.getProduct(10026);
		Assert.assertNotNull(product);
		
		//==> console Ȯ��
		System.out.println(product);
			
		//==> API Ȯ��
		Assert.assertEquals("���̾�", product.getProdName());
		Assert.assertEquals("���̾�", product.getProdDetail());
		Assert.assertEquals("20220409", product.getManuDate());
		Assert.assertEquals(10000, product.getPrice());
		Assert.assertEquals("demian.gif", product.getFileName());
	 }
	 
	//@Test //�̰� ProdNo�� �̹� sequence�� �־��� ������ �� �ʿ䰡 ����.
//	public void testCheckDuplication() throws Exception{
//
//		//==> �ʿ��ϴٸ�...
////		User user = new User();
////		user.setUserId("testUserId");
////		user.setUserName("testUserName");
////		user.setPassword("testPasswd");
////		user.setSsn("1111112222222");
////		user.setPhone("111-2222-3333");
////		user.setAddr("��⵵");
////		user.setEmail("test@test.com");
////		
////		userService.addUser(user);
//		
//		//==> console Ȯ��
//		System.out.println(productService.checkDuplication("testUserId"));
//		System.out.println(productService.checkDuplication("testUserId"+System.currentTimeMillis()) );
//	 	
//		//==> API Ȯ��
//		Assert.assertFalse( userService.checkDuplication("testUserId") );
//	 	Assert.assertTrue( userService.checkDuplication("testUserId"+System.currentTimeMillis()) );
//		 	
//	}
	
	 //==>  �ּ��� Ǯ�� �����ϸ�....
	 //@Test // 2022-04-11 shhwang
	 public void testGetProductListAll() throws Exception{
		 
		 	Search search = new Search();
		 	search.setCurrentPage(1);
		 	search.setPageSize(3);
		 	Map<String,Object> map = productService.getProductList(search);
		 	
		 	List<Object> list = (List<Object>)map.get("list");
		 	Assert.assertEquals(3, list.size());
		 	
			//==> console Ȯ��
		 	//System.out.println(list);
		 	
		 	Integer totalCount = (Integer)map.get("totalCount");
		 	System.out.println(totalCount);
		 	
		 	System.out.println("=======================================");
		 	
		 	search.setCurrentPage(1);
		 	search.setPageSize(3);
		 	search.setSearchCondition("0");
		 	search.setSearchKeyword("");
		 	map = productService.getProductList(search);
		 	
		 	list = (List<Object>)map.get("list");
		 	Assert.assertEquals(3, list.size());
		 	
		 	//==> console Ȯ��
		 	//System.out.println(list);
		 	
		 	totalCount = (Integer)map.get("totalCount");
		 	System.out.println(totalCount);
		 }
	 
	 @Test // 2022-04-11 shhwang
	 public void testGetProductListByProductNo() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("0");// default ���� 0 �̰� �̰��� jsp ���� setSearchCondition�� �־ where �� if������ ���δ�.
	 	search.setSearchKeyword("10026");//search�� ProductNo ���� select �ϰڴ�. 
	 	Map<String,Object> map = productService.getProductList(search);
	 	
	 	List<Object> list = (List<Object>)map.get("list");
	 	Assert.assertEquals(1, list.size());
	 	
		//==> console Ȯ��
	 	//System.out.println(list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	search.setSearchCondition("0");
	 	search.setSearchKeyword(""+System.currentTimeMillis());
	 	map = productService.getProductList(search);
	 	
	 	list = (List<Object>)map.get("list");
	 	Assert.assertEquals(0, list.size());
	 	
		//==> console Ȯ��
	 	//System.out.println(list);
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 }
	 
	 @Test // 2022-04-11 shhwang
	 public void testGetProductListByProductName() throws Exception{
		 
	 	Search search = new Search();
	 	search.setCurrentPage(1);
	 	search.setPageSize(3);
	 	search.setSearchCondition("1");//mapper���� prod_no ���� �˻��� ������ prod_name ���� �˻��� ������...
	 	search.setSearchKeyword("����");
	 	Map<String,Object> map = productService.getProductList(search);
	 	
	 	List<Object> list = (List<Object>)map.get("list");
	 	Assert.assertEquals(2, list.size());//setSearchKeyword ������ ���̺��� prod_name �� ������ŭ ��ġ�Ѵٸ�... 
	 	
		//==> console Ȯ��
	 	System.out.println(list);
	 	
	 	Integer totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 	
	 	System.out.println("=======================================");
	 	
	 	search.setSearchCondition("1");
	 	search.setSearchKeyword(""+System.currentTimeMillis());
	 	map = productService.getProductList(search);
	 	
	 	list = (List<Object>)map.get("list");
	 	Assert.assertEquals(0, list.size());
	 	
		//==> console Ȯ��
	 	System.out.println(list);
	 	
	 	totalCount = (Integer)map.get("totalCount");
	 	System.out.println(totalCount);
	 }	 
}