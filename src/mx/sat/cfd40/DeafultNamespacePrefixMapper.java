
package mx.sat.cfd40;


import com.sun.xml.bind.marshaller.NamespacePrefixMapper;
import java.util.HashMap;
import java.util.Map;

public class DeafultNamespacePrefixMapper extends NamespacePrefixMapper{
    
    //protected final ImmutableMap<String, String> PREFIXES = ImmutableMap.of("http://www.w3.org/2001/XMLSchema-instance", "xsi", "http://www.sat.gob.mx/cfd/4", "cfdi");
    
    private final Map<String, String> namespaceMap = new HashMap<>();
    
    public DeafultNamespacePrefixMapper(){
        namespaceMap.put("http://www.w3.org/2001/XMLSchema-instance", "xsi");
        namespaceMap.put("http://www.sat.gob.mx/cfd/4", "cfdi");
        //namespaceMap.put("http://www.sat.gob.mx/detallista", "detallista");
    }
    
    @Override
    public String getPreferredPrefix(String namespaceUri, String suggestion, boolean requirePrefix){
        return namespaceMap.getOrDefault(namespaceUri, suggestion);
    }
}
