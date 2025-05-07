package handMeDownsAPI.example.handMeDownsAPI.ProviderVisitStats;

import handMeDownsAPI.example.handMeDownsAPI.Provider.Provider;
import handMeDownsAPI.example.handMeDownsAPI.Provider.ProviderRepository;
import handMeDownsAPI.example.handMeDownsAPI.Provider.ProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/providers/stats")
public class ProviderVisitStatsController {

    @Autowired
    private ProviderVisitStatsService statsService;

    @Autowired
    private ProviderService providerService;

    //
    @GetMapping("/{storeID}")
    public String viewStats(@PathVariable int storeID, Model model) {
        Provider provider = providerService.getProviderById(storeID);
        if (provider != null) {
            model.addAttribute("provider", provider);
        }
        model.addAttribute("stats", statsService.getStatsForStore(storeID));

        return "provider-visit-stats";
    }

//    //
//    @GetMapping("/stats/{storeID}")
//    public String getStats(@PathVariable int storeID, Model model) {
//        Provider provider = providerService.getProviderById(storeID);
//
//        return "provider-statistics";
//    }
}
