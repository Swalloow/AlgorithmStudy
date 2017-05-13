package com.example.therealdanvega;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by junyoung on 2017. 5. 10..
 */

@RestController
public class PageController {

	@Value("${pageController.msg}")
	private String pageControllerMsg;
//	private NotificationService notificationService;
//
//	@Autowired
//	public PageController(NotificationService notificationService) {
//		this.notificationService = notificationService;
//	}

	@RequestMapping("/")
    public String home() {
//        return notificationService.toString();
		return pageControllerMsg;
    }
}
