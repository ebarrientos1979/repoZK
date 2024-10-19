package pe.edu.nh.objetos;

import org.zkoss.bind.annotation.*;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.*;
 
import java.util.stream.Collectors;
 
public class LanguageVM {
 
    private String name;
    private ListModelArray<String> proglangs;
 
    @Init
    public void init() {
        proglangs = new ListModelArray<>(new String[] {
                "Java", "C", "Python", "C++", "C#", "Visual Basic .NET",
                "JavaScript", "SQL", "PHP", "Objective-C", "Groovy",
                "Assembly language", "Delphi/Object Pascal", "Go", "Ruby",
                "Swift", "Visual Basic", "MATLAB", "R", "Perl", "SAS", "D",
                "PL/SQL", "Dart", "F#", "Transact-SQL", "ABSP", "Scratch",
                "TypeScript", "Scala", "COBOL", "Lisp", "Rust", "Fortran",
                "Ada", "Julia", "Kotlin", "ActionScript", "RPG", "Logo",
                "Lua", "Prolog", "Scheme", "PostScript", "LabVIEW",
                "VBScript", "Bash", "PL/I", "MS-DOS batch", "Haskell"
        });
        proglangs.setMultiple(true);
    }
 
    public String getName() {
        return name;
    }
 
    public void setName(String name) {
        this.name = name;
    }
 
    public ListModel<String> getProglangs() {
        return proglangs;
    }
 
    @Command
    public void show() {
        Clients.showNotification(String.format(
                "You are familiar with %s.",
                proglangs.getSelection().stream().collect(Collectors.joining(", "))
        ));
    }
}