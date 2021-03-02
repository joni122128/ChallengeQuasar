package com.operacion.quasar.interfaces;
import java.util.List;
import com.operacion.quasar.utils.ErrorHandler;

public interface IMessageService {
	public String getMessage(List<String[]> messages) throws ErrorHandler;
}
