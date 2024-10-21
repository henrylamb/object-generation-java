package org.objectGeneration.jsonSchema;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.objectGeneration.client.ReqFormat;

import java.util.List;
import java.util.Map;

public class Definition {

    @JsonProperty("type")
    private String type;
    private String instruction;
    private Map<String, Definition> properties;
    private Definition items;
    private String model;
    private List<String> processingOrder;
    private String systemPrompt;
    private boolean improvementProcess;
    private HashMap hashMap;
    private TextToSpeech textToSpeech;
    private SpeechToText speechToText;
    private Image image;
    private ReqFormat req;
    private Focus narrowFocus;
    private List<String> selectFields;
    private Choices choices;
    private boolean voters;
    private SendImage sendImage;
    private boolean stream;

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }

    public Map<String, Definition> getProperties() {
        return properties;
    }

    public void setProperties(Map<String, Definition> properties) {
        this.properties = properties;
    }

    public Definition getItems() {
        return items;
    }

    public void setItems(Definition items) {
        this.items = items;
    }


    public List<String> getProcessingOrder() {
        return processingOrder;
    }

    public void setProcessingOrder(List<String> processingOrder) {
        this.processingOrder = processingOrder;
    }

    public String getSystemPrompt() {
        return systemPrompt;
    }

    public void setSystemPrompt(String systemPrompt) {
        this.systemPrompt = systemPrompt;
    }

    public boolean isImprovementProcess() {
        return improvementProcess;
    }

    public void setImprovementProcess(boolean improvementProcess) {
        this.improvementProcess = improvementProcess;
    }

    public HashMap getHashMap() {
        return hashMap;
    }

    public void setHashMap(HashMap hashMap) {
        this.hashMap = hashMap;
    }

    public TextToSpeech getTextToSpeech() {
        return textToSpeech;
    }

    public void setTextToSpeech(TextToSpeech textToSpeech) {
        this.textToSpeech = textToSpeech;
    }

    public SpeechToText getSpeechToText() {
        return speechToText;
    }

    public void setSpeechToText(SpeechToText speechToText) {
        this.speechToText = speechToText;
    }

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public Focus getNarrowFocus() {
        return narrowFocus;
    }

    public void setNarrowFocus(Focus narrowFocus) {
        this.narrowFocus = narrowFocus;
    }

    public List<String> getSelectFields() {
        return selectFields;
    }

    public void setSelectFields(List<String> selectFields) {
        this.selectFields = selectFields;
    }

    public Choices getChoices() {
        return choices;
    }

    public void setChoices(Choices choices) {
        this.choices = choices;
    }

    public boolean isVoters() {
        return voters;
    }

    public void setVoters(boolean voters) {
        this.voters = voters;
    }

    public SendImage getSendImage() {
        return sendImage;
    }

    public void setSendImage(SendImage sendImage) {
        this.sendImage = sendImage;
    }

    public boolean isStream() {
        return stream;
    }

    public void setStream(boolean stream) {
        this.stream = stream;
    }
// Getters and Setters

    // Getters and setters
    public ReqFormat getReq() {
        return req;
    }

    public void setReq(ReqFormat req) {
        this.req = req;
    }

    public void setType(String object) {
        this.type = object;
    }

    @Override
    public String toString() {
        return "Definition{" +
                "type='" + type + '\'' +
                ", instruction='" + instruction + '\'' +
                ", properties=" + properties +
                ", items=" + items +
                ", model='" + model + '\'' +
                ", processingOrder=" + processingOrder +
                ", systemPrompt='" + systemPrompt + '\'' +
                ", improvementProcess=" + improvementProcess +
                ", hashMap=" + hashMap +
                ", textToSpeech=" + textToSpeech +
                ", speechToText=" + speechToText +
                ", image=" + image +
                ", req=" + req +
                ", narrowFocus=" + narrowFocus +
                ", selectFields=" + selectFields +
                ", choices=" + choices +
                ", voters=" + voters +
                ", sendImage=" + sendImage +
                ", stream=" + stream +
                '}';
    }

    public void setModel(String model) {
        this.model = model;
    }
}
