package greatSage.memo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MemoController {
    @GetMapping("memo")
    public String memo(Model model){
        model.addAttribute("data", "Memo !!");
        return "memo";
    }

    @GetMapping("memo-mvc")
    public String memoMvc(@RequestParam(name = "name", required = false ) String name, Model model) {
        model.addAttribute("name", name);
        return "memo-template";
    }

    @GetMapping("memo-string")
    @ResponseBody
    public String memoString(@RequestParam("name") String name) {
        return "memo" + name;
    }

    @GetMapping("memo-api")
    @ResponseBody
    public Memo memoApi(@RequestParam("name") String name){
        Memo memo = new Memo();
        memo.setName(name);
        return memo;
    }

    static class Memo {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
