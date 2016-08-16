package cl.max.mybatis.config;

public class IBatisConfiguratorException extends Exception {

	private static final long serialVersionUID = -9163031343242918005L;

	IBatisConfiguratorException() {
	}

	IBatisConfiguratorException(String message) {
		super(message);
	}

	IBatisConfiguratorException(Throwable cause) {
		super(cause);
	}

	IBatisConfiguratorException(String message, Throwable cause) {
		super(message, cause);
	}
}
