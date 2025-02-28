package shop_management.shop_management;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EntityScan("shop_management.entity")
@SpringBootApplication(scanBasePackages = "shop_management")
@EnableJpaRepositories("shop_management.repository")
public class ShopManagementApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopManagementApplication.class, args);
	}

}
