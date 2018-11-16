//param: HashMap
public static JSONObject createGenericJSON(HashMap<String,String> jsonValues) {
        JSONObject jsonObj = null;
        Map<String,String> jsonMap = jsonValues;
        try{

            jsonObj = new JSONObject();

            for (Entry<String, String> entry : jsonMap.entrySet()) {
                jsonObj.put(entry.getKey(), entry.getValue());
            }
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return jsonObj;
    }
    
    //param: Map
     public static JSONObject createGenericJSON(Map<String,String> jsonValues) {
        JSONObject jsonObj = null;
        Map<String,String> jsonMap = jsonValues;
        try{

            jsonObj = new JSONObject();

            for (Entry<String, String> entry : jsonMap.entrySet()) {
                jsonObj.put(entry.getKey(), entry.getValue());
            }
        }
        catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return jsonObj;
    }
